package com.prosperity.pas.servicing.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/** JPA entity for servicing.pending_reallocation (generated from the contract data model ERD). */
@Entity
@Table(schema = "servicing", name = "pending_reallocation")
public class PendingReallocation {

    @Id
    @Column(name = "instruction_id")
    private UUID instructionId;

    @Column(name = "policy_id")
    private UUID policyId;

    @Column(name = "mode")
    private String mode;

    @Column(name = "preset_model")
    private String presetModel;

    @Column(name = "auto_rebalance")
    private Boolean autoRebalance;

    @Column(name = "cutoff_date")
    private LocalDate cutoffDate;

    @Column(name = "effective_at_next_anniv")
    private Boolean effectiveAtNextAnniv;

    @Column(name = "status")
    private String status;

    @Column(name = "submitted_at")
    private LocalDateTime submittedAt;

    @Column(name = "calc_version")
    private String calcVersion;

    public PendingReallocation() {
    }

    public UUID getInstructionId() {
        return instructionId;
    }

    public void setInstructionId(UUID instructionId) {
        this.instructionId = instructionId;
    }

    public UUID getPolicyId() {
        return policyId;
    }

    public void setPolicyId(UUID policyId) {
        this.policyId = policyId;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getPresetModel() {
        return presetModel;
    }

    public void setPresetModel(String presetModel) {
        this.presetModel = presetModel;
    }

    public Boolean getAutoRebalance() {
        return autoRebalance;
    }

    public void setAutoRebalance(Boolean autoRebalance) {
        this.autoRebalance = autoRebalance;
    }

    public LocalDate getCutoffDate() {
        return cutoffDate;
    }

    public void setCutoffDate(LocalDate cutoffDate) {
        this.cutoffDate = cutoffDate;
    }

    public Boolean getEffectiveAtNextAnniv() {
        return effectiveAtNextAnniv;
    }

    public void setEffectiveAtNextAnniv(Boolean effectiveAtNextAnniv) {
        this.effectiveAtNextAnniv = effectiveAtNextAnniv;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }

    public String getCalcVersion() {
        return calcVersion;
    }

    public void setCalcVersion(String calcVersion) {
        this.calcVersion = calcVersion;
    }

}
