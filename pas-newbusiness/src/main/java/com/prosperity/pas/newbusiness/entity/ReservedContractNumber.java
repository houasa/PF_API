package com.prosperity.pas.newbusiness.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * A reserved contract number (PAS-1). Recorded before any policy row exists; the
 * number is carried back on the TX103. A durable relational record in Aurora
 * PostgreSQL (the system of record) — not transient.
 */
@Entity
@Table(schema = "newbusiness", name = "reserved_contract_number")
public class ReservedContractNumber {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "application_ref")
    private String applicationRef;

    @Column(name = "contract_number")
    private String contractNumber;

    @Column(name = "reserved_at")
    private LocalDateTime reservedAt;

    public ReservedContractNumber() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getApplicationRef() {
        return applicationRef;
    }

    public void setApplicationRef(String applicationRef) {
        this.applicationRef = applicationRef;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public LocalDateTime getReservedAt() {
        return reservedAt;
    }

    public void setReservedAt(LocalDateTime reservedAt) {
        this.reservedAt = reservedAt;
    }
}
