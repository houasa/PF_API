package com.prosperity.pas.policy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

/** JPA entity for policy.policy_account (generated from the contract data model ERD). */
@Entity
@Table(schema = "policy", name = "policy_account")
public class PolicyAccount {

    @Id
    @Column(name = "account_id")
    private UUID accountId;

    @Column(name = "policy_id")
    private UUID policyId;

    @Column(name = "account_key")
    private String accountKey;

    @Column(name = "balance_minor")
    private Long balanceMinor;

    @Column(name = "account_type")
    private String accountType;

    public PolicyAccount() {
    }

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public UUID getPolicyId() {
        return policyId;
    }

    public void setPolicyId(UUID policyId) {
        this.policyId = policyId;
    }

    public String getAccountKey() {
        return accountKey;
    }

    public void setAccountKey(String accountKey) {
        this.accountKey = accountKey;
    }

    public Long getBalanceMinor() {
        return balanceMinor;
    }

    public void setBalanceMinor(Long balanceMinor) {
        this.balanceMinor = balanceMinor;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

}
