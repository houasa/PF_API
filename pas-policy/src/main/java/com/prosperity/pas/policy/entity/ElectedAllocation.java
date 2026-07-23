package com.prosperity.pas.policy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

/** JPA entity for policy.elected_allocation (generated from the contract data model ERD). */
@Entity
@Table(schema = "policy", name = "elected_allocation")
public class ElectedAllocation {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "policy_id")
    private UUID policyId;

    @Column(name = "invest_type")
    private String investType;

    @Column(name = "base_rate")
    private BigDecimal baseRate;

    public ElectedAllocation() {
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

    public String getInvestType() {
        return investType;
    }

    public void setInvestType(String investType) {
        this.investType = investType;
    }

    public BigDecimal getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(BigDecimal baseRate) {
        this.baseRate = baseRate;
    }

}
