package com.prosperity.pas.policy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

/** JPA entity for policy.policy_glwb (generated from the contract data model ERD). */
@Entity
@Table(schema = "policy", name = "policy_glwb")
public class PolicyGlwb {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "policy_id")
    private UUID policyId;

    @Column(name = "elected_option")
    private String electedOption;

    @Column(name = "income_base_minor")
    private Long incomeBaseMinor;

    @Column(name = "payout_basis")
    private String payoutBasis;

    @Column(name = "guaranteed_withdrawal_pct")
    private BigDecimal guaranteedWithdrawalPct;

    @Column(name = "income_base_principal_minor")
    private Long incomeBasePrincipalMinor;

    public PolicyGlwb() {
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

    public String getElectedOption() {
        return electedOption;
    }

    public void setElectedOption(String electedOption) {
        this.electedOption = electedOption;
    }

    public Long getIncomeBaseMinor() {
        return incomeBaseMinor;
    }

    public void setIncomeBaseMinor(Long incomeBaseMinor) {
        this.incomeBaseMinor = incomeBaseMinor;
    }

    public String getPayoutBasis() {
        return payoutBasis;
    }

    public void setPayoutBasis(String payoutBasis) {
        this.payoutBasis = payoutBasis;
    }

    public BigDecimal getGuaranteedWithdrawalPct() {
        return guaranteedWithdrawalPct;
    }

    public void setGuaranteedWithdrawalPct(BigDecimal guaranteedWithdrawalPct) {
        this.guaranteedWithdrawalPct = guaranteedWithdrawalPct;
    }

    public Long getIncomeBasePrincipalMinor() {
        return incomeBasePrincipalMinor;
    }

    public void setIncomeBasePrincipalMinor(Long incomeBasePrincipalMinor) {
        this.incomeBasePrincipalMinor = incomeBasePrincipalMinor;
    }

}
