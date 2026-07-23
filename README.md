# PF_API — Prosperity PathWay Max PAS (walking skeleton)

Micro-PAS API with an embedded, in-process Micro-Product Engine (architecture
Decision A1). This is a **walking skeleton**: one thin vertical slice through the
whole stack — HTTP → Micro-PAS service → Product Engine → value + calculation
trace — for a single operation, **New Business PE-4 `computePremiumBonus`**.

The engine is plain compiled Java (architecture **Decision B1**). An OpenL Tablets
spike was evaluated and removed after compiled Java performed significantly better
(see M5 in `docs/product-engine/spec-mismatches.md`).

## Modules
| Module | Role |
|---|---|
| `pas-common` | Shared value types: `Money` (BigDecimal-backed), `ProductVersion`, `GlwbOption`, `CalculationTrace`. No Spring. |
| `product-engine` | Pure, deterministic engine (plain Java). `computePremiumBonus`. No Spring, no I/O. |
| `pas-api` | Spring Boot host — single front door; wires the engine in-process; owns the DB (Flyway + H2). |

## Database

The contract data model (New Business + In-Force Year 1 + First-Year Anniversary,
34 tables, per the ERD) is created by a **Flyway** baseline migration:
`pas-api/src/main/resources/db/migration/V1__contract_data_model.sql`.

Locally/tests it runs on **in-memory H2 in PostgreSQL-compatibility mode**, so the
same migration script also applies to **Aurora PostgreSQL** (architecture §2/§6).
Flyway runs automatically on app startup. Money is integer minor units (`*_minor`
`BIGINT`); ledger/audit/calculation-trace remain in DynamoDB (out of scope here).

## Requirements
- JDK 21 (architecture targets Java 25; realign later — see M4 in `docs/product-engine/spec-mismatches.md`)
- Maven (wrapper included: `./mvnw`)

## Build & test
```bash
./mvnw test
```

## Run
```bash
./mvnw -am -pl pas-api package -DskipTests
java -jar pas-api/target/pas-api-0.1.0-SNAPSHOT.jar
```

Then call the endpoint (premium $231,000 = 23,100,000 minor units):
```bash
curl -s -X POST localhost:8080/pas/v1/calc/premium-bonus \
  -H 'Content-Type: application/json' \
  -d '{"premiumMinor":23100000,"currency":"USD"}'
```
Expected: `premiumBonusMinor 1848000`, `accumulationValueMinor 24948000`, plus a
calculation trace. OpenAPI/Swagger UI at `/swagger-ui.html`.

## Design notes
- **Money (M1):** BigDecimal-backed; full precision internally; rounded to cents
  only at the wire boundary. Integer minor units are the API format only.
- **GLWB options (M2):** `GLN` / `GLS` / `GLC`.
- **Trace:** every engine determination returns inputs, pinned config version,
  intermediate figures, and rules applied.
- Decisions and cross-spec mismatches are tracked in `docs/product-engine/`.

## Out of scope (skeleton)
Other engine ops; feature-module split; JPA entity mapping over the schema;
DynamoDB ledger/audit; Entra security; Docker/ECS; React SPAs; the In-Force /
Anniversary *operations* (the schema exists; the processing logic does not yet).
