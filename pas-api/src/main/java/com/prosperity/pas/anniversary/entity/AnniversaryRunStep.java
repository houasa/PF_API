package com.prosperity.pas.anniversary.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

/** JPA entity for anniversary.anniversary_run_step (generated from the contract data model ERD). */
@Entity
@Table(schema = "anniversary", name = "anniversary_run_step")
public class AnniversaryRunStep {

    @Id
    @Column(name = "step_id")
    private UUID stepId;

    @Column(name = "run_id")
    private UUID runId;

    @Column(name = "step_code")
    private String stepCode;

    @Column(name = "status")
    private String status;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    public AnniversaryRunStep() {
    }

    public UUID getStepId() {
        return stepId;
    }

    public void setStepId(UUID stepId) {
        this.stepId = stepId;
    }

    public UUID getRunId() {
        return runId;
    }

    public void setRunId(UUID runId) {
        this.runId = runId;
    }

    public String getStepCode() {
        return stepCode;
    }

    public void setStepCode(String stepCode) {
        this.stepCode = stepCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

}
