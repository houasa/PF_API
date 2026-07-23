package com.prosperity.pas.anniversary.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/** JPA entity for anniversary.indexed_term (generated from the contract data model ERD). */
@Entity
@Table(schema = "anniversary", name = "indexed_term")
public class IndexedTerm {

    @Id
    @Column(name = "term_id")
    private UUID termId;

    @Column(name = "policy_id")
    private UUID policyId;

    @Column(name = "account_id")
    private UUID accountId;

    @Column(name = "index_id")
    private String indexId;

    @Column(name = "contract_year")
    private Integer contractYear;

    @Column(name = "term_start_date")
    private LocalDate termStartDate;

    @Column(name = "term_end_date")
    private LocalDate termEndDate;

    @Column(name = "crediting_method")
    private String creditingMethod;

    @Column(name = "cap_rate")
    private BigDecimal capRate;

    @Column(name = "participation_rate")
    private BigDecimal participationRate;

    @Column(name = "spread")
    private BigDecimal spread;

    @Column(name = "floor")
    private BigDecimal floor;

    @Column(name = "start_index_value")
    private BigDecimal startIndexValue;

    @Column(name = "end_index_value")
    private BigDecimal endIndexValue;

    @Column(name = "growth_rate")
    private BigDecimal growthRate;

    @Column(name = "credited_interest_minor")
    private Long creditedInterestMinor;

    @Column(name = "credited_at")
    private LocalDateTime creditedAt;

    public IndexedTerm() {
    }

    public UUID getTermId() {
        return termId;
    }

    public void setTermId(UUID termId) {
        this.termId = termId;
    }

    public UUID getPolicyId() {
        return policyId;
    }

    public void setPolicyId(UUID policyId) {
        this.policyId = policyId;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public String getIndexId() {
        return indexId;
    }

    public void setIndexId(String indexId) {
        this.indexId = indexId;
    }

    public Integer getContractYear() {
        return contractYear;
    }

    public void setContractYear(Integer contractYear) {
        this.contractYear = contractYear;
    }

    public LocalDate getTermStartDate() {
        return termStartDate;
    }

    public void setTermStartDate(LocalDate termStartDate) {
        this.termStartDate = termStartDate;
    }

    public LocalDate getTermEndDate() {
        return termEndDate;
    }

    public void setTermEndDate(LocalDate termEndDate) {
        this.termEndDate = termEndDate;
    }

    public String getCreditingMethod() {
        return creditingMethod;
    }

    public void setCreditingMethod(String creditingMethod) {
        this.creditingMethod = creditingMethod;
    }

    public BigDecimal getCapRate() {
        return capRate;
    }

    public void setCapRate(BigDecimal capRate) {
        this.capRate = capRate;
    }

    public BigDecimal getParticipationRate() {
        return participationRate;
    }

    public void setParticipationRate(BigDecimal participationRate) {
        this.participationRate = participationRate;
    }

    public BigDecimal getSpread() {
        return spread;
    }

    public void setSpread(BigDecimal spread) {
        this.spread = spread;
    }

    public BigDecimal getFloor() {
        return floor;
    }

    public void setFloor(BigDecimal floor) {
        this.floor = floor;
    }

    public BigDecimal getStartIndexValue() {
        return startIndexValue;
    }

    public void setStartIndexValue(BigDecimal startIndexValue) {
        this.startIndexValue = startIndexValue;
    }

    public BigDecimal getEndIndexValue() {
        return endIndexValue;
    }

    public void setEndIndexValue(BigDecimal endIndexValue) {
        this.endIndexValue = endIndexValue;
    }

    public BigDecimal getGrowthRate() {
        return growthRate;
    }

    public void setGrowthRate(BigDecimal growthRate) {
        this.growthRate = growthRate;
    }

    public Long getCreditedInterestMinor() {
        return creditedInterestMinor;
    }

    public void setCreditedInterestMinor(Long creditedInterestMinor) {
        this.creditedInterestMinor = creditedInterestMinor;
    }

    public LocalDateTime getCreditedAt() {
        return creditedAt;
    }

    public void setCreditedAt(LocalDateTime creditedAt) {
        this.creditedAt = creditedAt;
    }

}
