package com.prosperity.pas.engine;

import org.openl.rules.calc.SpreadsheetResult;

import java.math.BigDecimal;

/**
 * OpenL Tablets binding interface for {@code rules/PremiumBonus.xlsx}.
 *
 * <p>The method name and signature match the Spreadsheet table declared in the
 * workbook: {@code Spreadsheet SpreadsheetResult PremiumBonus(BigDecimal premium,
 * BigDecimal rate)}. Inputs are {@link BigDecimal} so the arithmetic stays on the
 * BigDecimal path (decision M1) — never OpenL's default {@code double}.
 */
public interface PremiumBonusRules {

    SpreadsheetResult PremiumBonus(BigDecimal premium, BigDecimal rate);
}
