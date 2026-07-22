# Micro-Product Engine — Cross-Spec Mismatches & Decisions Log

Running memory of inconsistencies found between the two Micro-Product Engine
tech specs we're building from. **Anniversary spec is intentionally excluded
(pending completion).**

Sources:
- `TechSpec_NewBusiness_ProductEngine_v0.1.md` (New Business)
- `PathWayMax_InForceY1_ProductEngine_TechSpec.md` (In-Force Year 1)

Status legend: 🔴 open · 🟡 proposed · 🟢 decided

---

## M1 — Money representation mismatch 🟢 DECIDED
- **New Business spec:** `long …Minor` — integer **minor units (cents)**, no binary float.
- **In-Force Y1 spec:** `Money` (BigDecimal-backed); rounding mode/scale from config (IFY1-A2).
- **Core architecture doc mandate:** `java.math.BigDecimal` + a project `Money` type; "no binary floating point anywhere in the money path"; rounding mode and scale declared in product configuration.
- **Why it matters:** the engine does daily-compound intermediates (`(1+r)^(days/365)`, participation × growth). Integer cents cannot carry sub-cent precision through those steps → accumulated rounding error. BigDecimal-backed `Money` at full internal precision, rounded to the cent only when booked, is the architecture's intent.
- **DECISION (2026-07-22, user):** use a single **BigDecimal-backed `Money`** type across both domains, with scale/rounding from product configuration (never literals). Carry full precision internally; round to the cent only at ledger booking / display. Integer `long` minor units are permitted **only** as an API/DTO wire format (e.g. New Business `amountMinor`), converted to `Money` at the service boundary before any math. Rationale in `precision-money-vs-bigdecimal.md`.

## M2 — `GlwbOption` enum naming mismatch 🟢 DECIDED
- **New Business spec:** `GlwbOption { OPT1, OPT2, OPT3 }`
- **In-Force Y1 spec:** `GlwbOption { GLN, GLS, GLC }`
- Same three options (OPT1=GLN, OPT2=GLS, OPT3=GLC). FRDs and product docs use the form codes GLN/GLS/GLC.
- **DECISION (2026-07-22, user):** unify on `GlwbOption { GLN, GLS, GLC }` (matches the filed form codes). If the inbound TX103 wire format carries OPT1/2/3, map it to GLN/GLS/GLC at the ingest boundary — the domain enum is GLN/GLS/GLC everywhere internally.

## M4 — Toolchain: Java 25 (architecture) vs JDK 21 (environment) 🟡
- Architecture mandates **Java 25**; the build environment has **JDK 21**.
- Skeleton builds with `maven.compiler.release = 21` (Spring Boot 3.4.x supports 21).
- **Action:** realign to Java 25 when a JDK 25 toolchain is available (bump the
  parent `maven.compiler.release`).

## M5 — Rules representation: OpenL spike vs Decision B1 🟡 SPIKING
- Architecture **Decision B1** chose typed config + plain Java evaluators and
  rejected embedded rules engines (Drools/KIE; OpenL is the same category).
- **User direction (2026-07-22):** spike **OpenL Tablets** on the simplest op
  before committing. Implemented in the walking skeleton: `computePremiumBonus`
  is backed by an OpenL **Spreadsheet** table (`product-engine/.../rules/PremiumBonus.xlsx`).
- **Spike outcome so far (positive):**
  - Computes the FRD worked example correctly ($231,000 → bonus $18,480 → AV $249,480).
  - Confirmed **BigDecimal** arithmetic (M1 honored) — engine asserts the OpenL
    result type is `BigDecimal`, not `double`; wire value `18480.0000`.
  - `SpreadsheetResult` rows map cleanly to `CalculationTrace.intermediateFigures`.
  - Authoring note: leading-`=` step cells must be stored as **text** in the
    `.xlsx` (openpyxl otherwise writes an Excel formula whose cached value is null
    and OpenL reads null). Generator forces `data_type='s'`.
  - `ProductEngine` interface stays plain, so the OpenL impl (`OpenlProductEngine`)
    is swappable for a plain-Java impl with zero `pas-api` change if the spike is
    rejected at scale.
- **Still open:** whether OpenL earns its keep across all ops (ergonomics/weight
  vs plain Java); this is a per-op-scaling decision, not settled by one op.

## M3 — Per-domain PE-n numbering collision 🟡
- Both specs number calls `PE-1…PE-n` scoped to their own domain (e.g. NB PE-1 = `resolveProductConfigVersion`, IFY1 PE-1 = `computeRiderCharge`).
- Not a code bug, but ambiguous in conversation/traceability.
- **Proposed resolution:** namespace when referring across specs (e.g. `NB.PE-1`, `IFY1.PE-1`), or give methods domain-prefixed identifiers in the code catalog.

---

## Notes
- Both specs agree the engine is **pure/stateless**, returns `{ value, CalculationTrace }`, PAS owns all persistence, in-process per architecture Decision A1.
- Open engine-relevant config items to set before implementation: day-count actual/365 (IFY1-A1), rounding cent/half-up (IFY1-A2), guaranteed-withdrawal-% table (OQ-2/FYA-O1, servicing-stage).

_Last updated: 2026-07-22_
