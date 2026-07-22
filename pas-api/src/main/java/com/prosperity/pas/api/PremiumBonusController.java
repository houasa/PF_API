package com.prosperity.pas.api;

import com.prosperity.pas.api.dto.PremiumBonusRequest;
import com.prosperity.pas.api.dto.PremiumBonusResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Micro-PAS front-door endpoint for New Business PE-4 (premium bonus).
 *
 * <p>Thin: it validates/maps and delegates to {@link PremiumBonusService}, which
 * calls the embedded Product Engine. Skeleton compute endpoint — no persistence,
 * no Idempotency-Key (this op writes nothing); it will be absorbed into the
 * Activate flow later.
 */
@RestController
@RequestMapping("/pas/v1/calc")
public class PremiumBonusController {

    private final PremiumBonusService service;

    public PremiumBonusController(PremiumBonusService service) {
        this.service = service;
    }

    @PostMapping("/premium-bonus")
    public PremiumBonusResponse premiumBonus(@RequestBody PremiumBonusRequest request) {
        return service.computePremiumBonus(request);
    }
}
