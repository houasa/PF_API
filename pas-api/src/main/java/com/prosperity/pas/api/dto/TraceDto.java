package com.prosperity.pas.api.dto;

import com.prosperity.pas.common.CalculationTrace;

import java.util.List;
import java.util.Map;

/** Wire view of a {@link CalculationTrace}. */
public record TraceDto(
        Map<String, String> inputs,
        String configVersion,
        Map<String, String> intermediateFigures,
        List<String> rulesApplied) {

    public static TraceDto from(CalculationTrace trace) {
        return new TraceDto(
                trace.inputs(),
                trace.configVersion(),
                trace.intermediateFigures(),
                trace.rulesApplied());
    }
}
