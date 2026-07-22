package com.prosperity.pas.api;

import com.prosperity.pas.api.dto.PremiumBonusRequest;
import com.prosperity.pas.api.dto.PremiumBonusResponse;
import com.prosperity.pas.api.dto.TraceDto;
import com.prosperity.pas.common.Money;
import com.prosperity.pas.common.ProductVersion;
import com.prosperity.pas.engine.PremiumBonusResult;
import com.prosperity.pas.engine.ProductConfigProvider;
import com.prosperity.pas.engine.ProductEngine;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;

/**
 * Micro-PAS service for the premium-bonus operation.
 *
 * <p>Converts the wire minor-units amount to {@code Money}, pins the product
 * configuration version, calls the in-process engine, and maps the result to the
 * response — rounding to cents only here, at the boundary (M1).
 */
@Service
public class PremiumBonusService {

    private final ProductEngine engine;

    public PremiumBonusService(ProductEngine engine) {
        this.engine = engine;
    }

    public PremiumBonusResponse computePremiumBonus(PremiumBonusRequest request) {
        Money premium = Money.ofMinor(request.premiumMinor());
        ProductVersion pinnedVersion = ProductConfigProvider.DEFAULT_VERSION;

        PremiumBonusResult result = engine.computePremiumBonus(premium, pinnedVersion);

        long premiumBonusMinor = result.premiumBonus().toMinorUnits(RoundingMode.HALF_UP);
        long accumulationValueMinor = result.accumulationValue().toMinorUnits(RoundingMode.HALF_UP);

        return new PremiumBonusResponse(
                premiumBonusMinor,
                accumulationValueMinor,
                request.currency(),
                TraceDto.from(result.trace()));
    }
}
