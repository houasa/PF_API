package com.prosperity.pas.api;

import com.prosperity.pas.api.dto.ReserveContractNumberRequest;
import com.prosperity.pas.api.dto.ReserveContractNumberResponse;
import com.prosperity.pas.newbusiness.service.ContractNumberService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * PAS-1 front-door endpoint: reserve a contract number for an application reference.
 *
 * <p>Thin controller — binds/maps and delegates to {@link ContractNumberService}.
 * {@code POST /pas/v1/contract-numbers:reserve} → 201 with the reserved number.
 */
@RestController
@RequestMapping("/pas/v1")
public class ContractNumberController {

    private final ContractNumberService service;

    public ContractNumberController(ContractNumberService service) {
        this.service = service;
    }

    @PostMapping("/contract-numbers:reserve")
    @ResponseStatus(HttpStatus.CREATED)
    public ReserveContractNumberResponse reserve(@RequestBody ReserveContractNumberRequest request) {
        return new ReserveContractNumberResponse(service.reserve(request.applicationRef()));
    }
}
