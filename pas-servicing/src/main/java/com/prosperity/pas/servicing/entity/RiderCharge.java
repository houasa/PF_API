package com.prosperity.pas.servicing.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/** JPA entity for servicing.rider_charge (generated from the contract data model ERD). */
@Entity
@Table(schema = "servicing", name = "rider_charge")
public class RiderCharge {

    @Id
    @Column(name = "charge_id")
    private UUID chargeId;

    @Column(name = "policy_id")
    private UUID policyId;

    @Column(name = "charge_date")
    private LocalDate chargeDate;

    @Column(name = "charge_rate")
    private BigDecimal chargeRate;

    @Column(name = "income_base_at_charge_minor")
    private Long incomeBaseAtChargeMinor;

    @Column(name = "charge_amount_minor")
    private Long chargeAmountMinor;

    @Column(name = "calc_version")
    private String calcVersion;

    public RiderCharge() {
    }

    public UUID getChargeId() {
        return chargeId;
    }

    public void setChargeId(UUID chargeId) {
        this.chargeId = chargeId;
    }

    public UUID getPolicyId() {
        return policyId;
    }

    public void setPolicyId(UUID policyId) {
        this.policyId = policyId;
    }

    public LocalDate getChargeDate() {
        return chargeDate;
    }

    public void setChargeDate(LocalDate chargeDate) {
        this.chargeDate = chargeDate;
    }

    public BigDecimal getChargeRate() {
        return chargeRate;
    }

    public void setChargeRate(BigDecimal chargeRate) {
        this.chargeRate = chargeRate;
    }

    public Long getIncomeBaseAtChargeMinor() {
        return incomeBaseAtChargeMinor;
    }

    public void setIncomeBaseAtChargeMinor(Long incomeBaseAtChargeMinor) {
        this.incomeBaseAtChargeMinor = incomeBaseAtChargeMinor;
    }

    public Long getChargeAmountMinor() {
        return chargeAmountMinor;
    }

    public void setChargeAmountMinor(Long chargeAmountMinor) {
        this.chargeAmountMinor = chargeAmountMinor;
    }

    public String getCalcVersion() {
        return calcVersion;
    }

    public void setCalcVersion(String calcVersion) {
        this.calcVersion = calcVersion;
    }

}
