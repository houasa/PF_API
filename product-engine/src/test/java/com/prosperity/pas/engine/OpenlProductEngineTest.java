package com.prosperity.pas.engine;

import com.prosperity.pas.common.Money;
import com.prosperity.pas.common.ProductVersion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Spike verification: OpenL computes the premium bonus in BigDecimal (M1) and the
 * result carries a usable calculation trace. Worked example from New Business FRD §6:
 * premium $231,000 → bonus 8% $18,480 → Accumulation Value $249,480.
 */
class OpenlProductEngineTest {

    private static ProductEngine engine;

    @BeforeAll
    static void setUp() {
        engine = new OpenlProductEngine(OpenlRules.load(), new ProductConfigProvider());
    }

    @Test
    void computesPremiumBonusFromFrdWorkedExample() {
        var result = engine.computePremiumBonus(
                Money.of(new BigDecimal("231000")), ProductConfigProvider.DEFAULT_VERSION);

        assertEquals(0, result.premiumBonus().amount().compareTo(new BigDecimal("18480")),
                "premium bonus should be 18480");
        assertEquals(0, result.accumulationValue().amount().compareTo(new BigDecimal("249480")),
                "accumulation value should be 249480");
    }

    @Test
    void traceCarriesConfigVersionAndSteps() {
        var result = engine.computePremiumBonus(
                Money.of(new BigDecimal("231000")), ProductConfigProvider.DEFAULT_VERSION);
        var trace = result.trace();

        assertEquals("v2026.2", trace.configVersion());
        assertTrue(trace.rulesApplied().contains("NB.PE-4"));
        assertEquals("0.08", trace.intermediateFigures().get("premiumBonusRate"));
        assertTrue(trace.intermediateFigures().containsKey("premiumBonus"));
        assertTrue(trace.intermediateFigures().containsKey("accumulationValue"));
    }
}
