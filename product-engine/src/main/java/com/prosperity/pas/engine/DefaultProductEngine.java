package com.prosperity.pas.engine;

import com.prosperity.pas.common.CalculationTrace;
import com.prosperity.pas.common.Money;
import com.prosperity.pas.common.ProductVersion;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Plain-Java, deterministic {@link ProductEngine} implementation (architecture Decision B1).
 *
 * <p>Replaces the earlier OpenL spike, which was removed after compiled Java
 * proved significantly faster. The premium-bonus math is a direct BigDecimal
 * computation reading the pinned bonus rate from {@link ProductConfigProvider}
 * (config, not a literal). Pure: no I/O, persists nothing; carries full precision
 * internally (M1) and returns a {@link CalculationTrace}.
 */
public final class DefaultProductEngine implements ProductEngine {

    private final ProductConfigProvider configProvider;

    public DefaultProductEngine(ProductConfigProvider configProvider) {
        this.configProvider = Objects.requireNonNull(configProvider, "configProvider");
    }

    @Override
    public PremiumBonusResult computePremiumBonus(Money premium, ProductVersion configVersion) {
        ProductConfig config = configProvider.resolve(configVersion);

        BigDecimal rate = config.premiumBonusRate();
        BigDecimal premiumBonus = premium.amount().multiply(rate);
        BigDecimal accumulationValue = premium.amount().add(premiumBonus);

        Map<String, String> inputs = new LinkedHashMap<>();
        inputs.put("premium", premium.amount().toPlainString());

        Map<String, String> intermediates = new LinkedHashMap<>();
        intermediates.put("premiumBonusRate", rate.toPlainString());
        intermediates.put("premiumBonus", premiumBonus.toPlainString());
        intermediates.put("accumulationValue", accumulationValue.toPlainString());

        CalculationTrace trace = new CalculationTrace(
                inputs,
                config.version().value(),
                intermediates,
                List.of("NB.PE-4"));

        return new PremiumBonusResult(Money.of(premiumBonus), Money.of(accumulationValue), trace);
    }
}
