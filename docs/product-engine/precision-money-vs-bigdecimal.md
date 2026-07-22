# Does using `Money` lose precision vs `BigDecimal`?

**Short answer: no — not from `Money` itself.** In these specs `Money` is
*BigDecimal-backed*, so it is a wrapper around `BigDecimal`, not a lower-precision
alternative to it. It cannot lose precision relative to the `BigDecimal` it holds;
it only adds a currency and a rounding/scale policy on top.

The precision question that actually matters here is **integer minor units (`long`
cents) vs `BigDecimal`** — which is exactly the M1 mismatch between the two specs.

## The three representations, ranked by precision

| Representation | Exactly represents | Precision risk |
|---|---|---|
| `double` / `float` | binary fractions only | **Loses precision** — 0.1 is not exact; forbidden on the money path |
| `long` minor units (cents) | whole cents only | Exact for whole cents; **cannot hold sub-cent intermediates** |
| `BigDecimal` (and `Money` wrapping it) | any decimal to its scale | Exact to the configured scale; **highest precision** |

## Why `long` cents is the weaker choice for the *engine*

The engine's math is not just add/subtract of booked amounts — it compounds daily:

```
IB_end = IB_start × (1 + r)^(segmentDays / 365)     // roll-up
credit = growth × participationRate                  // index crediting
gmcsv  = 0.875 × premium × (1.03)^(days / 365)        // guaranteed minimum
```

These produce **fractional cents**. With `long` cents you must round at every
intermediate step, and daily compounding over a year accumulates that rounding
into a visible error. `BigDecimal` carries full precision through the whole
chain and rounds **once, at booking** — which is precisely what the In-Force FRD
mandates ("carried at full precision internally and rounded to the cent when
booked to the ledger", IFY1-A2).

## The one nuance about `Money`

`Money` preserves `BigDecimal` precision **only if it doesn't force a low scale on
construction.** If a `Money` type were built to snap every value to 2 decimals
immediately, it would behave like `long` cents and defeat the purpose. So the
design rule:

- **Money for the money path**, BigDecimal-backed, with a **high internal scale**
  (e.g. carry many decimal places) and rounding/scale pulled from **product config**
  (not literals) per the architecture.
- **Round to the cent only at ledger booking / display**, never mid-calculation.
- Integer `long` minor units are fine as an **API/DTO wire format** (New Business's
  `amountMinor`), converted to `Money` at the service boundary before any math.

## Conclusion
- `Money` (BigDecimal-backed) ≈ `BigDecimal` in precision — no loss.
- `long` cents **does** lose precision for the engine's compounding intermediates.
- Adopt one BigDecimal-backed `Money` type across both domains (M1), round only at
  booking. This satisfies the architecture's "no binary float, config-driven
  rounding" mandate and the FRDs' full-precision-internally rule.

_Last updated: 2026-07-22_
