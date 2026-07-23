package com.prosperity.pas;

import com.prosperity.pas.anniversary.entity.AnniversaryRun;
import com.prosperity.pas.anniversary.entity.IndexValue;
import com.prosperity.pas.anniversary.entity.IndexValueId;
import com.prosperity.pas.anniversary.repo.AnniversaryRunRepository;
import com.prosperity.pas.anniversary.repo.IndexValueRepository;
import com.prosperity.pas.policy.entity.Policy;
import com.prosperity.pas.policy.entity.PolicyAccount;
import com.prosperity.pas.policy.repo.PolicyAccountRepository;
import com.prosperity.pas.policy.repo.PolicyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Round-trips JPA entities against the Flyway-created, schema-per-module database:
 * proves the entity mappings (schema-qualified tables, columns, types, composite
 * key) line up with the migration. Transactional → rolled back after each test.
 */
@SpringBootTest
@Transactional
class JpaPersistenceTest {

    @Autowired PolicyRepository policies;
    @Autowired PolicyAccountRepository accounts;
    @Autowired AnniversaryRunRepository runs;
    @Autowired IndexValueRepository indexValues;

    @Test
    void policyAndChildAccountRoundTrip() {
        UUID policyId = UUID.randomUUID();
        Policy p = new Policy();
        p.setPolicyId(policyId);
        p.setPolNumber("PWM-2026-000123");
        p.setStatus("Active");
        p.setJurisdiction("AZ");
        p.setAccumulationValueMinor(24_948_000L);
        p.setGmvMinor(24_948_000L);
        policies.saveAndFlush(p);

        // FK policy_id (schema policy → policy.policy_account) resolves within the tx.
        PolicyAccount a = new PolicyAccount();
        a.setAccountId(UUID.randomUUID());
        a.setPolicyId(policyId);
        a.setAccountKey("FIXED");
        a.setAccountType("FIXED");
        a.setBalanceMinor(16_200_00L);
        accounts.saveAndFlush(a);

        Policy found = policies.findById(policyId).orElseThrow();
        assertEquals(24_948_000L, found.getAccumulationValueMinor());
        assertEquals("Active", found.getStatus());
    }

    @Test
    void anniversaryRunRoundTrip() {
        UUID policyId = UUID.randomUUID();
        Policy p = new Policy();
        p.setPolicyId(policyId);
        p.setStatus("Active");
        policies.saveAndFlush(p);

        UUID runId = UUID.randomUUID();
        AnniversaryRun run = new AnniversaryRun();
        run.setRunId(runId);
        run.setPolicyId(policyId);
        run.setStatus("PENDING");
        run.setAnniversaryDate(LocalDate.of(2027, 1, 15));
        runs.saveAndFlush(run);

        assertTrue(runs.findById(runId).isPresent());
    }

    @Test
    void indexValueCompositeKeyRoundTrip() {
        IndexValue iv = new IndexValue();
        iv.setIndexId("SP500");
        iv.setBusinessDate(LocalDate.of(2027, 1, 15));
        iv.setCloseValue(new BigDecimal("5123.456700"));
        iv.setSource("mocked");
        indexValues.saveAndFlush(iv);

        IndexValue found = indexValues.findById(new IndexValueId("SP500", LocalDate.of(2027, 1, 15)))
                .orElseThrow();
        assertEquals(0, found.getCloseValue().compareTo(new BigDecimal("5123.4567")));
    }
}
