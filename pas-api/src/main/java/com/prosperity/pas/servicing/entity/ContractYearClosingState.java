package com.prosperity.pas.servicing.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

/** JPA entity for servicing.contract_year_closing_state (generated from the contract data model ERD). */
@Entity
@Table(schema = "servicing", name = "contract_year_closing_state")
public class ContractYearClosingState {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "policy_id")
    private UUID policyId;

    @Column(name = "pending_instruction_id")
    private UUID pendingInstructionId;

    @Column(name = "as_of_date")
    private LocalDate asOfDate;

    @Column(name = "accumulation_value_minor")
    private Long accumulationValueMinor;

    @Column(name = "fixed_account_value_minor")
    private Long fixedAccountValueMinor;

    @Column(name = "income_base_minor")
    private Long incomeBaseMinor;

    @Column(name = "held_additional_premium_minor")
    private Long heldAdditionalPremiumMinor;

    @Column(name = "gmv_minor")
    private Long gmvMinor;

    @Column(name = "gmcsv_minor")
    private Long gmcsvMinor;

    @Column(name = "handoff_status")
    private String handoffStatus;

    public ContractYearClosingState() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPolicyId() {
        return policyId;
    }

    public void setPolicyId(UUID policyId) {
        this.policyId = policyId;
    }

    public UUID getPendingInstructionId() {
        return pendingInstructionId;
    }

    public void setPendingInstructionId(UUID pendingInstructionId) {
        this.pendingInstructionId = pendingInstructionId;
    }

    public LocalDate getAsOfDate() {
        return asOfDate;
    }

    public void setAsOfDate(LocalDate asOfDate) {
        this.asOfDate = asOfDate;
    }

    public Long getAccumulationValueMinor() {
        return accumulationValueMinor;
    }

    public void setAccumulationValueMinor(Long accumulationValueMinor) {
        this.accumulationValueMinor = accumulationValueMinor;
    }

    public Long getFixedAccountValueMinor() {
        return fixedAccountValueMinor;
    }

    public void setFixedAccountValueMinor(Long fixedAccountValueMinor) {
        this.fixedAccountValueMinor = fixedAccountValueMinor;
    }

    public Long getIncomeBaseMinor() {
        return incomeBaseMinor;
    }

    public void setIncomeBaseMinor(Long incomeBaseMinor) {
        this.incomeBaseMinor = incomeBaseMinor;
    }

    public Long getHeldAdditionalPremiumMinor() {
        return heldAdditionalPremiumMinor;
    }

    public void setHeldAdditionalPremiumMinor(Long heldAdditionalPremiumMinor) {
        this.heldAdditionalPremiumMinor = heldAdditionalPremiumMinor;
    }

    public Long getGmvMinor() {
        return gmvMinor;
    }

    public void setGmvMinor(Long gmvMinor) {
        this.gmvMinor = gmvMinor;
    }

    public Long getGmcsvMinor() {
        return gmcsvMinor;
    }

    public void setGmcsvMinor(Long gmcsvMinor) {
        this.gmcsvMinor = gmcsvMinor;
    }

    public String getHandoffStatus() {
        return handoffStatus;
    }

    public void setHandoffStatus(String handoffStatus) {
        this.handoffStatus = handoffStatus;
    }

}
