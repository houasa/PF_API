package com.prosperity.pas.policy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

/** JPA entity for policy.party_role (generated from the contract data model ERD). */
@Entity
@Table(schema = "policy", name = "party_role")
public class PartyRole {

    @Id
    @Column(name = "role_id")
    private UUID roleId;

    @Column(name = "policy_id")
    private UUID policyId;

    @Column(name = "party_id")
    private UUID partyId;

    @Column(name = "relation_role_code")
    private String relationRoleCode;

    @Column(name = "interest_percent")
    private BigDecimal interestPercent;

    @Column(name = "irrevocable_flag")
    private Boolean irrevocableFlag;

    public PartyRole() {
    }

    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    public UUID getPolicyId() {
        return policyId;
    }

    public void setPolicyId(UUID policyId) {
        this.policyId = policyId;
    }

    public UUID getPartyId() {
        return partyId;
    }

    public void setPartyId(UUID partyId) {
        this.partyId = partyId;
    }

    public String getRelationRoleCode() {
        return relationRoleCode;
    }

    public void setRelationRoleCode(String relationRoleCode) {
        this.relationRoleCode = relationRoleCode;
    }

    public BigDecimal getInterestPercent() {
        return interestPercent;
    }

    public void setInterestPercent(BigDecimal interestPercent) {
        this.interestPercent = interestPercent;
    }

    public Boolean getIrrevocableFlag() {
        return irrevocableFlag;
    }

    public void setIrrevocableFlag(Boolean irrevocableFlag) {
        this.irrevocableFlag = irrevocableFlag;
    }

}
