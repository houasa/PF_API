package com.prosperity.pas.api;

import com.prosperity.pas.engine.DefaultProductEngine;
import com.prosperity.pas.engine.ProductConfigProvider;
import com.prosperity.pas.engine.ProductEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Wires the Micro-Product Engine in-process (Decision A1).
 *
 * <p>Plain-Java engine ({@link DefaultProductEngine}) per Decision B1 — the OpenL
 * spike was removed after compiled Java proved significantly faster.
 */
@Configuration
public class EngineConfig {

    @Bean
    ProductConfigProvider productConfigProvider() {
        return new ProductConfigProvider();
    }

    @Bean
    ProductEngine productEngine(ProductConfigProvider configProvider) {
        return new DefaultProductEngine(configProvider);
    }
}
