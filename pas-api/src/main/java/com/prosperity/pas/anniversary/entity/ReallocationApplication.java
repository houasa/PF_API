package com.prosperity.pas.anniversary.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

/** JPA entity for anniversary.reallocation_application (generated from the contract data model ERD). */
@Entity
@Table(schema = "anniversary", name = "reallocation_application")
public class ReallocationApplication {

    @Id
    @Column(name = "application_id")
    private UUID applicationId;

    @Column(name = "policy_id")
    private UUID policyId;

    @Column(name = "run_id")
    private UUID runId;

    @Column(name = "source_instruction_id")
    private UUID sourceInstructionId;

    @Column(name = "anniversary_date")
    private LocalDate anniversaryDate;

    @Column(name = "auto_rebalance_applied")
    private Boolean autoRebalanceApplied;

    @Column(name = "held_premium_moved_minor")
    private Long heldPremiumMovedMinor;

    public ReallocationApplication() {
    }

    public UUID getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(UUID applicationId) {
        this.applicationId = applicationId;
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

    public UUID getSourceInstructionId() {
        return sourceInstructionId;
    }

    public void setSourceInstructionId(UUID sourceInstructionId) {
        this.sourceInstructionId = sourceInstructionId;
    }

    public LocalDate getAnniversaryDate() {
        return anniversaryDate;
    }

    public void setAnniversaryDate(LocalDate anniversaryDate) {
        this.anniversaryDate = anniversaryDate;
    }

    public Boolean getAutoRebalanceApplied() {
        return autoRebalanceApplied;
    }

    public void setAutoRebalanceApplied(Boolean autoRebalanceApplied) {
        this.autoRebalanceApplied = autoRebalanceApplied;
    }

    public Long getHeldPremiumMovedMinor() {
        return heldPremiumMovedMinor;
    }

    public void setHeldPremiumMovedMinor(Long heldPremiumMovedMinor) {
        this.heldPremiumMovedMinor = heldPremiumMovedMinor;
    }

}
