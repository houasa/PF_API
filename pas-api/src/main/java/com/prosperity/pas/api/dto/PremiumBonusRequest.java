package com.prosperity.pas.api.dto;

/**
 * Premium-bonus request. Money on the wire is integer minor units (cents) per the
 * New Business spec; it is converted to {@code Money} at the service boundary.
 */
public record PremiumBonusRequest(long premiumMinor, String currency) {
}
