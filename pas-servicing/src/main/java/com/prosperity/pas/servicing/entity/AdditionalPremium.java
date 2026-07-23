package com.prosperity.pas.servicing.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

/** JPA entity for servicing.additional_premium (generated from the contract data model ERD). */
@Entity
@Table(schema = "servicing", name = "additional_premium")
public class AdditionalPremium {

    @Id
    @Column(name = "receivable_id")
    private UUID receivableId;

    @Column(name = "policy_id")
    private UUID policyId;

    @Column(name = "amount_minor")
    private Long amountMinor;

    @Column(name = "funding_type")
    private String fundingType;

    @Column(name = "received_date")
    private LocalDate receivedDate;

    @Column(name = "settlement_date")
    private LocalDate settlementDate;

    @Column(name = "decision")
    private String decision;

    @Column(name = "status")
    private String status;

    @Column(name = "premium_bonus_minor")
    private Long premiumBonusMinor;

    @Column(name = "rider_bonus_minor")
    private Long riderBonusMinor;

    @Column(name = "cumulative_premium_after_minor")
    private Long cumulativePremiumAfterMinor;

    @Column(name = "idempotency_key")
    private String idempotencyKey;

    @Column(name = "calc_version")
    private String calcVersion;

    public AdditionalPremium() {
    }

    public UUID getReceivableId() {
        return receivableId;
    }

    public void setReceivableId(UUID receivableId) {
        this.receivableId = receivableId;
    }

    public UUID getPolicyId() {
        return policyId;
    }

    public void setPolicyId(UUID policyId) {
        this.policyId = policyId;
    }

    public Long getAmountMinor() {
        return amountMinor;
    }

    public void setAmountMinor(Long amountMinor) {
        this.amountMinor = amountMinor;
    }

    public String getFundingType() {
        return fundingType;
    }

    public void setFundingType(String fundingType) {
        this.fundingType = fundingType;
    }

    public LocalDate getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(LocalDate receivedDate) {
        this.receivedDate = receivedDate;
    }

    public LocalDate getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(LocalDate settlementDate) {
        this.settlementDate = settlementDate;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPremiumBonusMinor() {
        return premiumBonusMinor;
    }

    public void setPremiumBonusMinor(Long premiumBonusMinor) {
        this.premiumBonusMinor = premiumBonusMinor;
    }

    public Long getRiderBonusMinor() {
        return riderBonusMinor;
    }

    public void setRiderBonusMinor(Long riderBonusMinor) {
        this.riderBonusMinor = riderBonusMinor;
    }

    public Long getCumulativePremiumAfterMinor() {
        return cumulativePremiumAfterMinor;
    }

    public void setCumulativePremiumAfterMinor(Long cumulativePremiumAfterMinor) {
        this.cumulativePremiumAfterMinor = cumulativePremiumAfterMinor;
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
