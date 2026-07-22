# Micro-Product Engine — Cross-Spec Mismatches & Decisions Log

Running memory of inconsistencies found between the two Micro-Product Engine
tech specs we're building from. **Anniversary spec is intentionally excluded
(pending completion).**

Sources:
- `TechSpec_NewBusiness_ProductEngine_v0.1.md` (New Business)
- `PathWayMax_InForceY1_ProductEngine_TechSpec.md` (In-Force Year 1)

Status legend: 🔴 open · 🟡 proposed · 🟢 decided

---

## M1 — Money representation mismatch 🔴
- **New Business spec:** `long …Minor` — integer **minor units (cents)**, no binary float.
- **In-Force Y1 spec:** `Money` (BigDecimal-backed); rounding mode/scale from config (IFY1-A2).
- **Core architecture doc mandate:** `java.math.BigDecimal` + a project `Money` type; "no binary floating point anywhere in the money path"; rounding mode and scale declared in product configuration.
- **Why it matters:** the engine does daily-compound intermediates (`(1+r)^(days/365)`, participation × growth). Integer cents cannot carry sub-cent precision through those steps → accumulated rounding error. BigDecimal-backed `Money` at full internal precision, rounded to the cent only when booked, is the architecture's intent.
- **Proposed resolution:** single `Money` type (BigDecimal-backed, configurable scale/rounding) across both domains; minor-units `long` used only at the API/DTO boundary if needed, converted at the edge. See precision note in `precision-money-vs-bigdecimal.md`.

## M2 — `GlwbOption` enum naming mismatch 🔴
- **New Business spec:** `GlwbOption { OPT1, OPT2, OPT3 }`
- **In-Force Y1 spec:** `GlwbOption { GLN, GLS, GLC }`
- Same three options (OPT1=GLN, OPT2=GLS, OPT3=GLC). FRDs and product docs use the form codes GLN/GLS/GLC.
- **Proposed resolution:** unify on `GlwbOption { GLN, GLS, GLC }` (matches filed form codes); keep OPT1/2/3 only as inbound TX103 mapping if the wire format uses them.

## M3 — Per-domain PE-n numbering collision 🟡
- Both specs number calls `PE-1…PE-n` scoped to their own domain (e.g. NB PE-1 = `resolveProductConfigVersion`, IFY1 PE-1 = `computeRiderCharge`).
- Not a code bug, but ambiguous in conversation/traceability.
- **Proposed resolution:** namespace when referring across specs (e.g. `NB.PE-1`, `IFY1.PE-1`), or give methods domain-prefixed identifiers in the code catalog.

---

## Notes
- Both specs agree the engine is **pure/stateless**, returns `{ value, CalculationTrace }`, PAS owns all persistence, in-process per architecture Decision A1.
- Open engine-relevant config items to set before implementation: day-count actual/365 (IFY1-A1), rounding cent/half-up (IFY1-A2), guaranteed-withdrawal-% table (OQ-2/FYA-O1, servicing-stage).

_Last updated: 2026-07-22_
