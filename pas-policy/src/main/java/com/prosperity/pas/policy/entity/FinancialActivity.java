package com.prosperity.pas.policy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

/** JPA entity for policy.financial_activity (generated from the contract data model ERD). */
@Entity
@Table(schema = "policy", name = "financial_activity")
public class FinancialActivity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "policy_id")
    private UUID policyId;

    @Column(name = "fin_activity_type")
    private String finActivityType;

    @Column(name = "payment_form")
    private String paymentForm;

    @Column(name = "payment_amt")
    private BigDecimal paymentAmt;

    @Column(name = "payment_method")
    private String paymentMethod;

    public FinancialActivity() {
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

    public String getFinActivityType() {
        return finActivityType;
    }

    public void setFinActivityType(String finActivityType) {
        this.finActivityType = finActivityType;
    }

    public String getPaymentForm() {
        return paymentForm;
    }

    public void setPaymentForm(String paymentForm) {
        this.paymentForm = paymentForm;
    }

    public BigDecimal getPaymentAmt() {
        return paymentAmt;
    }

    public void setPaymentAmt(BigDecimal paymentAmt) {
        this.paymentAmt = paymentAmt;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

}
