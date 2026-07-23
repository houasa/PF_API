package com.prosperity.pas.policy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

/** JPA entity for policy.elected_rider (generated from the contract data model ERD). */
@Entity
@Table(schema = "policy", name = "elected_rider")
public class ElectedRider {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "policy_id")
    private UUID policyId;

    @Column(name = "rider_code")
    private String riderCode;

    @Column(name = "description")
    private String description;

    @Column(name = "feature_name")
    private String featureName;

    public ElectedRider() {
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

    public String getRiderCode() {
        return riderCode;
    }

    public void setRiderCode(String riderCode) {
        this.riderCode = riderCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

}
