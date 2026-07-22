package com.prosperity.pas.api;

import com.prosperity.pas.engine.OpenlProductEngine;
import com.prosperity.pas.engine.OpenlRules;
import com.prosperity.pas.engine.PremiumBonusRules;
import com.prosperity.pas.engine.ProductConfigProvider;
import com.prosperity.pas.engine.ProductEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Wires the Micro-Product Engine in-process (Decision A1).
 *
 * <p>The OpenL workbook is compiled once here at startup — {@link OpenlRules#load()}
 * is heavy, so the resulting {@link PremiumBonusRules} proxy is a singleton bean.
 */
@Configuration
public class EngineConfig {

    @Bean
    ProductConfigProvider productConfigProvider() {
        return new ProductConfigProvider();
    }

    @Bean
    PremiumBonusRules premiumBonusRules() {
        return OpenlRules.load();
    }

    @Bean
    ProductEngine productEngine(PremiumBonusRules rules, ProductConfigProvider configProvider) {
        return new OpenlProductEngine(rules, configProvider);
    }
}
