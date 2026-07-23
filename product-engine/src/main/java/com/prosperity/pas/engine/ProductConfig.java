package com.prosperity.pas.engine;

import com.prosperity.pas.common.ProductVersion;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Versioned product configuration (the "data" half of the logic-vs-data split).
 * Pinned at issue; read by determinations. Rates/rounding live here, never as
 * literals in code.
 */
public record ProductConfig(
        ProductVersion version,
        BigDecimal premiumBonusRate,
        int scale,
        RoundingMode roundingMode) {
}
