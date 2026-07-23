package com.prosperity.pas.anniversary.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

/** JPA entity for anniversary.year_close_reconciliation (generated from the contract data model ERD). */
@Entity
@Table(schema = "anniversary", name = "year_close_reconciliation")
public class YearCloseReconciliation {

    @Id
    @Column(name = "recon_id")
    private UUID reconId;

    @Column(name = "policy_id")
    private UUID policyId;

    @Column(name = "run_id")
    private UUID runId;

    @Column(name = "anniversary_date")
    private LocalDate anniversaryDate;

    @Column(name = "pre_av_minor")
    private Long preAvMinor;

    @Column(name = "post_av_minor")
    private Long postAvMinor;

    @Column(name = "rounding_residual_minor")
    private Long roundingResidualMinor;

    @Column(name = "opening_next_year_av_minor")
    private Long openingNextYearAvMinor;

    @Column(name = "status")
    private String status;

    public YearCloseReconciliation() {
    }

    public UUID getReconId() {
        return reconId;
    }

    public void setReconId(UUID reconId) {
        this.reconId = reconId;
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

    public Long getPreAvMinor() {
        return preAvMinor;
    }

    public void setPreAvMinor(Long preAvMinor) {
        this.preAvMinor = preAvMinor;
    }

    public Long getPostAvMinor() {
        return postAvMinor;
    }

    public void setPostAvMinor(Long postAvMinor) {
        this.postAvMinor = postAvMinor;
    }

    public Long getRoundingResidualMinor() {
        return roundingResidualMinor;
    }

    public void setRoundingResidualMinor(Long roundingResidualMinor) {
        this.roundingResidualMinor = roundingResidualMinor;
    }

    public Long getOpeningNextYearAvMinor() {
        return openingNextYearAvMinor;
    }

    public void setOpeningNextYearAvMinor(Long openingNextYearAvMinor) {
        this.openingNextYearAvMinor = openingNextYearAvMinor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
