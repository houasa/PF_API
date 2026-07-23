# PF_API — Prosperity PathWay Max PAS (walking skeleton)

Micro-PAS API with an embedded, in-process Micro-Product Engine (architecture
Decision A1). This is a **walking skeleton**: one thin vertical slice through the
whole stack — HTTP → Micro-PAS service → Product Engine → value + calculation
trace — for a single operation, **New Business PE-4 `computePremiumBonus`**.

The engine is plain compiled Java (architecture **Decision B1**). An OpenL Tablets
spike was evaluated and removed after compiled Java performed significantly better
(see M5 in `docs/product-engine/spec-mismatches.md`).

## Modules

Maven multi-module (`pas-api → domain modules → product-engine → pas-common`):

| Module | Role | Deps |
|---|---|---|
| `pas-common` | Shared value types: `Money` (BigDecimal-backed), `ProductVersion`, `GlwbOption`, `CalculationTrace`. No Spring. | — |
| `product-engine` | Pure, deterministic engine (plain Java): `computePremiumBonus`. Owns the `product_config` entity (JPA annotations only). No Spring, no I/O. | pas-common, jakarta.persistence-api |
| `pas-newbusiness` | `newbusiness` schema entities (TX103 submission). | jakarta.persistence-api |
| `pas-policy` | `policy` schema: policy record, parties, elections, accounts — entities + repositories. | jakarta.persistence-api, spring-data-jpa |
| `pas-servicing` | `servicing` schema: In-Force Year 1 accrual/servicing entities. | jakarta.persistence-api |
| `pas-anniversary` | `anniversary` schema: anniversary run & output entities + repositories. | jakarta.persistence-api, spring-data-jpa |
| `pas-api` | Spring Boot host — single front door; wires the engine in-process; owns the Flyway migration + datasource; depends on all domain modules. | all of the above + web/jpa/flyway/h2 |

Domain modules are compile-independent (FKs are plain UUID columns, not JPA
associations), so none depends on another; `pas-api` composes them.

## Database

The contract data model (New Business + In-Force Year 1 + First-Year Anniversary,
34 tables, per the ERD) is created by a **Flyway** baseline migration:
`pas-api/src/main/resources/db/migration/V1__contract_data_model.sql`.

Locally/tests it runs on **in-memory H2 in PostgreSQL-compatibility mode**, so the
same migration script also applies to **Aurora PostgreSQL** (architecture §2/§6).
Flyway runs on startup; Hibernate `ddl-auto=none` (Flyway owns the schema). Money
is integer minor units (`*_minor` `BIGINT`); ledger/audit/calculation-trace remain
in DynamoDB (out of scope here).

### Schema-per-module + JPA entities

Tables are split into one **schema per domain module** (architecture §6.1), and
each schema has JPA `@Entity` classes in a matching Java package
(`com.prosperity.pas.<module>.entity`). These packages map 1:1 to the feature
Maven modules to be extracted later.

| Schema | Owning module | Java package | Tables |
|---|---|---|---|
| `product_config` | product-engine | `productconfig.entity` | 1 |
| `newbusiness` | pas-newbusiness | `newbusiness.entity` | 1 |
| `policy` | pas-policy | `policy.entity` | 16 (policy hub, party, elections, accounts) |
| `servicing` | pas-servicing | `servicing.entity` | 8 (In-Force Year 1 accrual/servicing) |
| `anniversary` | pas-anniversary | `anniversary.entity` | 8 (anniversary run & outputs) |

FKs are modeled as plain UUID/String columns for now (JPA associations can be
added later); `index_value` uses a composite key (`IndexValueId`). A handful of
Spring Data repositories (`policy.repo`, `anniversary.repo`) exist for the
round-trip test.

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
Other engine ops; physical feature-Maven-module split (packages stand in for now);
JPA associations between entities; DynamoDB ledger/audit; Entra security;
Docker/ECS; React SPAs; the In-Force / Anniversary *operations* (schema + entities
exist; the processing logic does not yet).
