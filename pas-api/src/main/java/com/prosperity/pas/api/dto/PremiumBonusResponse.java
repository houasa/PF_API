package com.prosperity.pas.api.dto;

/** Premium-bonus response. Money returned as integer minor units (cents), rounded at this boundary. */
public record PremiumBonusResponse(
        long premiumBonusMinor,
        long accumulationValueMinor,
        String currency,
        TraceDto trace) {
}
