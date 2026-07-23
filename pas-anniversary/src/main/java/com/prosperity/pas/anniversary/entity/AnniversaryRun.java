package com.prosperity.pas.anniversary.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/** JPA entity for anniversary.anniversary_run (generated from the contract data model ERD). */
@Entity
@Table(schema = "anniversary", name = "anniversary_run")
public class AnniversaryRun {

    @Id
    @Column(name = "run_id")
    private UUID runId;

    @Column(name = "policy_id")
    private UUID policyId;

    @Column(name = "snapshot_id")
    private UUID snapshotId;

    @Column(name = "anniversary_date")
    private LocalDate anniversaryDate;

    @Column(name = "execution_date")
    private LocalDate executionDate;

    @Column(name = "status")
    private String status;

    @Column(name = "lease_owner")
    private String leaseOwner;

    @Column(name = "lease_expires_at")
    private LocalDateTime leaseExpiresAt;

    @Column(name = "idempotency_key")
    private String idempotencyKey;

    @Column(name = "calc_version")
    private String calcVersion;

    public AnniversaryRun() {
    }

    public UUID getRunId() {
        return runId;
    }

    public void setRunId(UUID runId) {
        this.runId = runId;
    }

    public UUID getPolicyId() {
        return policyId;
    }

    public void setPolicyId(UUID policyId) {
        this.policyId = policyId;
    }

    public UUID getSnapshotId() {
        return snapshotId;
    }

    public void setSnapshotId(UUID snapshotId) {
        this.snapshotId = snapshotId;
    }

    public LocalDate getAnniversaryDate() {
        return anniversaryDate;
    }

    public void setAnniversaryDate(LocalDate anniversaryDate) {
        this.anniversaryDate = anniversaryDate;
    }

    public LocalDate getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(LocalDate executionDate) {
        this.executionDate = executionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLeaseOwner() {
        return leaseOwner;
    }

    public void setLeaseOwner(String leaseOwner) {
        this.leaseOwner = leaseOwner;
    }

    public LocalDateTime getLeaseExpiresAt() {
        return leaseExpiresAt;
    }

    public void setLeaseExpiresAt(LocalDateTime leaseExpiresAt) {
        this.leaseExpiresAt = leaseExpiresAt;
    }

    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    public void setIdempotencyKey(String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
    }

    public String getCalcVersion() {
        return calcVersion;
    }

    public void setCalcVersion(String calcVersion) {
        this.calcVersion = calcVersion;
    }

}
