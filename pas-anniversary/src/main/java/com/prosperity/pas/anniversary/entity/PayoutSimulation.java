package com.prosperity.pas.anniversary.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/** JPA entity for anniversary.payout_simulation (generated from the contract data model ERD). */
@Entity
@Table(schema = "anniversary", name = "payout_simulation")
public class PayoutSimulation {

    @Id
    @Column(name = "simulation_id")
    private UUID simulationId;

    @Column(name = "policy_id")
    private UUID policyId;

    @Column(name = "run_id")
    private UUID runId;

    @Column(name = "anniversary_date")
    private LocalDate anniversaryDate;

    @Column(name = "basis")
    private String basis;

    @Column(name = "assumed_election_age")
    private Integer assumedElectionAge;

    @Column(name = "income_base_at_sim_minor")
    private Long incomeBaseAtSimMinor;

    @Column(name = "guaranteed_withdrawal_pct")
    private BigDecimal guaranteedWithdrawalPct;

    @Column(name = "mawb_minor")
    private Long mawbMinor;

    public PayoutSimulation() {
    }

    public UUID getSimulationId() {
        return simulationId;
    }

    public void setSimulationId(UUID simulationId) {
        this.simulationId = simulationId;
    }

    public UUID getPolicyId() {
        return policyId;
    }

    public void setPolicyId(UUID policyId) {
        this.policyId = policyId;
    }

    public UUID getRunId() {
        return runId;
    }

    public void setRunId(UUID runId) {
        this.runId = runId;
    }

    public LocalDate getAnniversaryDate() {
        return anniversaryDate;
    }

    public void setAnniversaryDate(LocalDate anniversaryDate) {
        this.anniversaryDate = anniversaryDate;
    }

    public String getBasis() {
        return basis;
    }

    public void setBasis(String basis) {
        this.basis = basis;
    }

    public Integer getAssumedElectionAge() {
        return assumedElectionAge;
    }

    public void setAssumedElectionAge(Integer assumedElectionAge) {
        this.assumedElectionAge = assumedElectionAge;
    }

    public Long getIncomeBaseAtSimMinor() {
        return incomeBaseAtSimMinor;
    }

    public void setIncomeBaseAtSimMinor(Long incomeBaseAtSimMinor) {
        this.incomeBaseAtSimMinor = incomeBaseAtSimMinor;
    }

    public BigDecimal getGuaranteedWithdrawalPct() {
        return guaranteedWithdrawalPct;
    }

    public void setGuaranteedWithdrawalPct(BigDecimal guaranteedWithdrawalPct) {
        this.guaranteedWithdrawalPct = guaranteedWithdrawalPct;
    }

    public Long getMawbMinor() {
        return mawbMinor;
    }

    public void setMawbMinor(Long mawbMinor) {
        this.mawbMinor = mawbMinor;
    }

}
