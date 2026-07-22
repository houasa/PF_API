package com.prosperity.pas.engine;

import com.prosperity.pas.common.Money;
import com.prosperity.pas.common.ProductVersion;

/**
 * Micro-Product Engine — pure, deterministic calculator (architecture §5, Decision A1).
 *
 * <p>Every operation is a function of its explicit inputs plus the policy's pinned
 * product-configuration version. It performs no I/O, persists nothing, and returns
 * a value plus a {@link com.prosperity.pas.common.CalculationTrace}; the Micro-PAS
 * owns all persistence.
 *
 * <p>Skeleton scope: only New Business PE-4 {@code computePremiumBonus}.
 */
public interface ProductEngine {

    /** New Business PE-4: premium bonus and the resulting Accumulation Value. */
    PremiumBonusResult computePremiumBonus(Money premium, ProductVersion configVersion);
}
