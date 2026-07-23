package com.prosperity.pas.servicing.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/** JPA entity for servicing.gmcsv_tranche (generated from the contract data model ERD). */
@Entity
@Table(schema = "servicing", name = "gmcsv_tranche")
public class GmcsvTranche {

    @Id
    @Column(name = "tranche_id")
    private UUID trancheId;

    @Column(name = "policy_id")
    private UUID policyId;

    @Column(name = "receivable_id")
    private UUID receivableId;

    @Column(name = "premium_tranche_minor")
    private Long premiumTrancheMinor;

    @Column(name = "receipt_date")
    private LocalDate receiptDate;

    @Column(name = "gmcsv_pct")
    private BigDecimal gmcsvPct;

    @Column(name = "gmcsv_rate")
    private BigDecimal gmcsvRate;

    public GmcsvTranche() {
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

    public Long getPremiumTrancheMinor() {
        return premiumTrancheMinor;
    }

    public void setPremiumTrancheMinor(Long premiumTrancheMinor) {
        this.premiumTrancheMinor = premiumTrancheMinor;
    }

    public LocalDate getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(LocalDate receiptDate) {
        this.receiptDate = receiptDate;
    }

    public BigDecimal getGmcsvPct() {
        return gmcsvPct;
    }

    public void setGmcsvPct(BigDecimal gmcsvPct) {
        this.gmcsvPct = gmcsvPct;
    }

    public BigDecimal getGmcsvRate() {
        return gmcsvRate;
    }

    public void setGmcsvRate(BigDecimal gmcsvRate) {
        this.gmcsvRate = gmcsvRate;
    }

}
