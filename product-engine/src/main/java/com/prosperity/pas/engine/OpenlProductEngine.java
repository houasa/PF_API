package com.prosperity.pas.engine;

import com.prosperity.pas.common.CalculationTrace;
import com.prosperity.pas.common.Money;
import com.prosperity.pas.common.ProductVersion;
import org.openl.rules.calc.SpreadsheetResult;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * OpenL-backed {@link ProductEngine} implementation (the spike).
 *
 * <p>Delegates the money math to the {@code PremiumBonus} OpenL Spreadsheet table,
 * reads the pinned bonus rate from {@link ProductConfigProvider} (config, not a
 * literal), and maps the {@link SpreadsheetResult} steps into a
 * {@link CalculationTrace}. Pure: no I/O, persists nothing.
 *
 * <p>If OpenL proves unsuitable, only this class is replaced — {@code pas-api}
 * depends on {@link ProductEngine}, not on OpenL.
 */
public final class OpenlProductEngine implements ProductEngine {

    private final PremiumBonusRules rules;
    private final ProductConfigProvider configProvider;

    public OpenlProductEngine(PremiumBonusRules rules, ProductConfigProvider configProvider) {
        this.rules = Objects.requireNonNull(rules, "rules");
        this.configProvider = Objects.requireNonNull(configProvider, "configProvider");
    }

    @Override
    public PremiumBonusResult computePremiumBonus(Money premium, ProductVersion configVersion) {
        ProductConfig config = configProvider.resolve(configVersion);

        SpreadsheetResult result = rules.PremiumBonus(premium.amount(), config.premiumBonusRate());

        BigDecimal premiumBonus = bigDecimal(field(result, "PremiumBonus"));
        BigDecimal accumulationValue = bigDecimal(field(result, "AccumulationValue"));

        Map<String, String> inputs = new LinkedHashMap<>();
        inputs.put("premium", premium.amount().toPlainString());

        Map<String, String> intermediates = new LinkedHashMap<>();
        intermediates.put("premiumBonusRate", config.premiumBonusRate().toPlainString());
        intermediates.put("premiumBonus", premiumBonus.toPlainString());
        intermediates.put("accumulationValue", accumulationValue.toPlainString());

        CalculationTrace trace = new CalculationTrace(
                inputs,
                config.version().value(),
                intermediates,
                List.of("NB.PE-4", "PremiumBonus.xlsx"));

        return new PremiumBonusResult(Money.of(premiumBonus), Money.of(accumulationValue), trace);
    }

    /** Read a named row from the single-value-column spreadsheet result. */
    private static Object field(SpreadsheetResult result, String rowName) {
        String[] rows = result.getRowNames();
        for (int i = 0; i < rows.length; i++) {
            if (rowName.equals(rows[i])) {
                return result.getValue(i, 0);
            }
        }
        throw new IllegalStateException(
                "OpenL spreadsheet row not found: " + rowName + " (rows=" + String.join(",", rows) + ")");
    }

    /** Enforce the M1 precision decision: the engine must hand back BigDecimal, not double. */
    private static BigDecimal bigDecimal(Object value) {
        if (value instanceof BigDecimal bd) {
            return bd;
        }
        throw new IllegalStateException("Expected BigDecimal from OpenL (M1 precision), got: "
                + (value == null ? "null" : value.getClass().getName()));
    }
}
