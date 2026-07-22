package com.prosperity.pas.common;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * BigDecimal-backed money type for the PAS/Engine money path (decision M1).
 *
 * <p>Carries full internal precision — construction never forces a scale — so
 * intermediate calculations (roll-up, crediting, bonuses) lose no precision.
 * Rounding to the cent happens only at explicit boundaries: {@link #roundToCents}
 * for display and {@link #toMinorUnits} for the API wire format. No binary
 * floating point is used anywhere.
 */
public record Money(BigDecimal amount) {

    public Money {
        Objects.requireNonNull(amount, "amount");
    }

    public static Money of(BigDecimal amount) {
        return new Money(amount);
    }

    /** Build from integer minor units (cents), the API/DTO wire format. */
    public static Money ofMinor(long minorUnits) {
        return new Money(BigDecimal.valueOf(minorUnits, 2));
    }

    public Money add(Money other) {
        return new Money(this.amount.add(other.amount));
    }

    /** Round to whole cents (scale 2) using the given mode — display boundary only. */
    public Money roundToCents(RoundingMode mode) {
        return new Money(amount.setScale(2, mode));
    }

    /** Convert to integer minor units (cents) — the API wire format. */
    public long toMinorUnits(RoundingMode mode) {
        return amount.movePointRight(2).setScale(0, mode).longValueExact();
    }
}
