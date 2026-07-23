package com.prosperity.pas.servicing.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/** JPA entity for servicing.fixed_interest_tranche (generated from the contract data model ERD). */
@Entity
@Table(schema = "servicing", name = "fixed_interest_tranche")
public class FixedInterestTranche {

    @Id
    @Column(name = "tranche_id")
    private UUID trancheId;

    @Column(name = "policy_id")
    private UUID policyId;

    @Column(name = "receivable_id")
    private UUID receivableId;

    @Column(name = "principal_minor")
    private Long principalMinor;

    @Column(name = "declared_rate")
    private BigDecimal declaredRate;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "source")
    private String source;

    public FixedInterestTranche() {
    }

    public UUID getTrancheId() {
        return trancheId;
    }

    public void setTrancheId(UUID trancheId) {
        this.trancheId = trancheId;
    }

    public UUID getPolicyId() {
        return policyId;
    }

    public void setPolicyId(UUID policyId) {
        this.policyId = policyId;
    }

    public UUID getReceivableId() {
        return receivableId;
    }

    public void setReceivableId(UUID receivableId) {
        this.receivableId = receivableId;
    }

    public Long getPrincipalMinor() {
        return principalMinor;
    }

    public void setPrincipalMinor(Long principalMinor) {
        this.principalMinor = principalMinor;
    }

    public BigDecimal getDeclaredRate() {
        return declaredRate;
    }

    public void setDeclaredRate(BigDecimal declaredRate) {
        this.declaredRate = declaredRate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}
