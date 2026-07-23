package com.prosperity.pas.newbusiness.service;

import com.prosperity.pas.newbusiness.entity.ReservedContractNumber;
import com.prosperity.pas.newbusiness.repo.ReservedContractNumberRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * PAS-1 {@code reserveContractNumber} (Micro-PAS New Business).
 *
 * <p>Reserves and returns a contract number for an application reference and
 * persists a reserved-number record. No {@code policy} row is created here (that
 * happens at Receive, PAS-2). The number format is {@code PWM-<year>-<6-digit
 * sequence>}. The {@code CONTRACT_NUMBER_RESERVED} audit event is a DynamoDB
 * concern and is out of scope for this local build.
 */
@Service
public class ContractNumberService {

    private final ReservedContractNumberRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    public ContractNumberService(ReservedContractNumberRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public String reserve(String applicationRef) {
        long sequence = ((Number) entityManager
                .createNativeQuery("select nextval('newbusiness.contract_number_seq')")
                .getSingleResult()).longValue();

        String contractNumber = String.format("PWM-%d-%06d", LocalDate.now().getYear(), sequence);

        ReservedContractNumber record = new ReservedContractNumber();
        record.setId(UUID.randomUUID());
        record.setApplicationRef(applicationRef);
        record.setContractNumber(contractNumber);
        record.setReservedAt(LocalDateTime.now());
        repository.save(record);

        return contractNumber;
    }
}
