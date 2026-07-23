package com.prosperity.pas.policy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

/** JPA entity for policy.elected_allocation_line (generated from the contract data model ERD). */
@Entity
@Table(schema = "policy", name = "elected_allocation_line")
public class ElectedAllocationLine {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "allocation_id")
    private UUID allocationId;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "transfer_pct")
    private BigDecimal transferPct;

    public ElectedAllocationLine() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getAllocationId() {
        return allocationId;
    }

    public void setAllocationId(UUID allocationId) {
        this.allocationId = allocationId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public BigDecimal getTransferPct() {
        return transferPct;
    }

    public void setTransferPct(BigDecimal transferPct) {
        this.transferPct = transferPct;
    }

}
