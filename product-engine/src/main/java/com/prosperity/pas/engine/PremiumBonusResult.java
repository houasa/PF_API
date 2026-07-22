package com.prosperity.pas.engine;

import com.prosperity.pas.common.CalculationTrace;
import com.prosperity.pas.common.Money;

/** Result of New Business PE-4 {@code computePremiumBonus}. */
public record PremiumBonusResult(
        Money premiumBonus,
        Money accumulationValue,
        CalculationTrace trace) {
}
