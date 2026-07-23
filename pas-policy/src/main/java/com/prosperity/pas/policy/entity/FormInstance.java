package com.prosperity.pas.policy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

/** JPA entity for policy.form_instance (generated from the contract data model ERD). */
@Entity
@Table(schema = "policy", name = "form_instance")
public class FormInstance {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "policy_id")
    private UUID policyId;

    @Column(name = "document_control_number")
    private String documentControlNumber;

    @Column(name = "document_control_type")
    private String documentControlType;

    @Column(name = "provider_form_number")
    private String providerFormNumber;

    @Column(name = "original_input_mode")
    private String originalInputMode;

    public FormInstance() {
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

    public String getDocumentControlNumber() {
        return documentControlNumber;
    }

    public void setDocumentControlNumber(String documentControlNumber) {
        this.documentControlNumber = documentControlNumber;
    }

    public String getDocumentControlType() {
        return documentControlType;
    }

    public void setDocumentControlType(String documentControlType) {
        this.documentControlType = documentControlType;
    }

    public String getProviderFormNumber() {
        return providerFormNumber;
    }

    public void setProviderFormNumber(String providerFormNumber) {
        this.providerFormNumber = providerFormNumber;
    }

    public String getOriginalInputMode() {
        return originalInputMode;
    }

    public void setOriginalInputMode(String originalInputMode) {
        this.originalInputMode = originalInputMode;
    }

}
