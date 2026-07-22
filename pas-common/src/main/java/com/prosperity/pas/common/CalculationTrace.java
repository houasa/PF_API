package com.prosperity.pas.common;

import java.util.List;
import java.util.Map;

/**
 * The reproducibility record every engine determination returns (architecture §5.5).
 *
 * <p>Captures the inputs, the pinned configuration version, the intermediate
 * figures, and the rules applied, so any figure can be recomputed and verified.
 * The Micro-PAS persists this alongside the result.
 *
 * <p>Skeleton note: values are kept as strings for simplicity; a richer typed
 * trace can replace this without changing the engine contract.
 */
public record CalculationTrace(
        Map<String, String> inputs,
        String configVersion,
        Map<String, String> intermediateFigures,
        List<String> rulesApplied) {
}
