package com.prosperity.pas.servicing.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

/** JPA entity for servicing.pending_reallocation_line (generated from the contract data model ERD). */
@Entity
@Table(schema = "servicing", name = "pending_reallocation_line")
public class PendingReallocationLine {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "instruction_id")
    private UUID instructionId;

    @Column(name = "account_key")
    private String accountKey;

    @Column(name = "target_pct")
    private BigDecimal targetPct;

    public PendingReallocationLine() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getInstructionId() {
        return instructionId;
    }

    public void setInstructionId(UUID instructionId) {
        this.instructionId = instructionId;
    }

    public String getAccountKey() {
        return accountKey;
    }

    public void setAccountKey(String accountKey) {
        this.accountKey = accountKey;
    }

    public BigDecimal getTargetPct() {
        return targetPct;
    }

    public void setTargetPct(BigDecimal targetPct) {
        this.targetPct = targetPct;
    }

}
