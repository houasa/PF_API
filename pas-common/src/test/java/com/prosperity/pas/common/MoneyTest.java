package com.prosperity.pas.common;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTest {

    @Test
    void ofMinorBuildsCentScaledAmount() {
        Money m = Money.ofMinor(23_100_000L); // $231,000.00
        assertEquals(new BigDecimal("231000.00"), m.amount());
    }

    @Test
    void toMinorUnitsRoundsToCents() {
        Money m = Money.of(new BigDecimal("18480.005"));
        assertEquals(1_848_001L, m.toMinorUnits(RoundingMode.HALF_UP));
    }

    @Test
    void constructionPreservesFullPrecision() {
        // No scale is forced on construction — intermediates keep full precision.
        Money m = Money.of(new BigDecimal("18480.123456789"));
        assertEquals(new BigDecimal("18480.123456789"), m.amount());
    }

    @Test
    void addKeepsPrecision() {
        Money sum = Money.of(new BigDecimal("231000")).add(Money.of(new BigDecimal("18480")));
        assertEquals(new BigDecimal("249480"), sum.amount());
    }
}
