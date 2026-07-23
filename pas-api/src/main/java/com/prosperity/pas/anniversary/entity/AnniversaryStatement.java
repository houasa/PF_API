package com.prosperity.pas.anniversary.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/** JPA entity for anniversary.anniversary_statement (generated from the contract data model ERD). */
@Entity
@Table(schema = "anniversary", name = "anniversary_statement")
public class AnniversaryStatement {

    @Id
    @Column(name = "statement_id")
    private UUID statementId;

    @Column(name = "policy_id")
    private UUID policyId;

    @Column(name = "run_id")
    private UUID runId;

    @Column(name = "anniversary_date")
    private LocalDate anniversaryDate;

    @Column(name = "payload_ref")
    private String payloadRef;

    @Column(name = "generated_at")
    private LocalDateTime generatedAt;

    @Column(name = "doc_gen_status")
    private String docGenStatus;

    @Column(name = "notification_status")
    private String notificationStatus;

    @Column(name = "idempotency_key")
    private String idempotencyKey;

    public AnniversaryStatement() {
    }

    public UUID getStatementId() {
        return statementId;
    }

    public void setStatementId(UUID statementId) {
        this.statementId = statementId;
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

    public String getPayloadRef() {
        return payloadRef;
    }

    public void setPayloadRef(String payloadRef) {
        this.payloadRef = payloadRef;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
    }

    public String getDocGenStatus() {
        return docGenStatus;
    }

    public void setDocGenStatus(String docGenStatus) {
        this.docGenStatus = docGenStatus;
    }

    public String getNotificationStatus() {
        return notificationStatus;
    }

    public void setNotificationStatus(String notificationStatus) {
        this.notificationStatus = notificationStatus;
    }

    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    public void setIdempotencyKey(String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
    }

}
