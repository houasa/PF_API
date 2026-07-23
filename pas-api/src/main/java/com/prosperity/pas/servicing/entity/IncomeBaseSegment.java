package com.prosperity.pas.servicing.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/** JPA entity for servicing.income_base_segment (generated from the contract data model ERD). */
@Entity
@Table(schema = "servicing", name = "income_base_segment")
public class IncomeBaseSegment {

    @Id
    @Column(name = "segment_id")
    private UUID segmentId;

    @Column(name = "policy_id")
    private UUID policyId;

    @Column(name = "receivable_id")
    private UUID receivableId;

    @Column(name = "segment_start_date")
    private LocalDate segmentStartDate;

    @Column(name = "method")
    private String method;

    @Column(name = "roll_up_rate")
    private BigDecimal rollUpRate;

    @Column(name = "base_at_start_minor")
    private Long baseAtStartMinor;

    @Column(name = "principal_minor")
    private Long principalMinor;

    @Column(name = "source")
    private String source;

    public IncomeBaseSegment() {
    }

    public UUID getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(UUID segmentId) {
        this.segmentId = segmentId;
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

    public LocalDate getSegmentStartDate() {
        return segmentStartDate;
    }

    public void setSegmentStartDate(LocalDate segmentStartDate) {
        this.segmentStartDate = segmentStartDate;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public BigDecimal getRollUpRate() {
        return rollUpRate;
    }

    public void setRollUpRate(BigDecimal rollUpRate) {
        this.rollUpRate = rollUpRate;
    }

    public Long getBaseAtStartMinor() {
        return baseAtStartMinor;
    }

    public void setBaseAtStartMinor(Long baseAtStartMinor) {
        this.baseAtStartMinor = baseAtStartMinor;
    }

    public Long getPrincipalMinor() {
        return principalMinor;
    }

    public void setPrincipalMinor(Long principalMinor) {
        this.principalMinor = principalMinor;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}
