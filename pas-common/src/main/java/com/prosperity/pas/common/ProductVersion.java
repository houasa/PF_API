package com.prosperity.pas.common;

import java.util.Objects;

/**
 * A pinned, immutable product-configuration version (e.g. {@code "v2026.2"}).
 * A policy pins one at issue; every determination reads that snapshot.
 */
public record ProductVersion(String value) {

    public ProductVersion {
        Objects.requireNonNull(value, "value");
    }

    public static ProductVersion of(String value) {
        return new ProductVersion(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
