package com.prosperity.pas.engine;

import com.prosperity.pas.common.ProductVersion;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

/**
 * Resolves a {@link ProductConfig} for a pinned {@link ProductVersion}.
 *
 * <p>Skeleton: an in-memory map with a single version. Later this is backed by
 * the {@code product_config} store (Aurora). PathWay Max premium bonus = 8%.
 */
public class ProductConfigProvider {

    public static final ProductVersion DEFAULT_VERSION = ProductVersion.of("v2026.2");

    private final Map<ProductVersion, ProductConfig> configs = Map.of(
            DEFAULT_VERSION,
            new ProductConfig(DEFAULT_VERSION, new BigDecimal("0.08"), 2, RoundingMode.HALF_UP));

    public ProductConfig resolve(ProductVersion version) {
        ProductConfig config = configs.get(version);
        if (config == null) {
            throw new IllegalArgumentException("Unknown product config version: " + version);
        }
        return config;
    }
}
