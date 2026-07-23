package com.prosperity.pas.policy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/** JPA entity for policy.policy (generated from the contract data model ERD). */
@Entity
@Table(schema = "policy", name = "policy")
public class Policy {

    @Id
    @Column(name = "policy_id")
    private UUID policyId;

    @Column(name = "submission_id")
    private UUID submissionId;

    @Column(name = "config_version")
    private String configVersion;

    @Column(name = "pol_number")
    private String polNumber;

    @Column(name = "holding_type_code")
    private String holdingTypeCode;

    @Column(name = "holding_status")
    private String holdingStatus;

    @Column(name = "policy_status")
    private String policyStatus;

    @Column(name = "line_of_business")
    private String lineOfBusiness;

    @Column(name = "currency_type_code")
    private String currencyTypeCode;

    @Column(name = "issue_nation")
    private String issueNation;

    @Column(name = "jurisdiction")
    private String jurisdiction;

    @Column(name = "cusip_num")
    private String cusipNum;

    @Column(name = "carrier_code")
    private String carrierCode;

    @Column(name = "carrier_comm_code")
    private String carrierCommCode;

    @Column(name = "tot_comm_retained")
    private BigDecimal totCommRetained;

    @Column(name = "distributor_client_acct_num")
    private String distributorClientAcctNum;

    @Column(name = "policy_value")
    private BigDecimal policyValue;

    @Column(name = "qual_plan_type")
    private String qualPlanType;

    @Column(name = "ee_contrib_amt")
    private BigDecimal eeContribAmt;

    @Column(name = "surrender_charge")
    private BigDecimal surrenderCharge;

    @Column(name = "status")
    private String status;

    @Column(name = "termination_reason")
    private String terminationReason;

    @Column(name = "issue_date")
    private LocalDate issueDate;

    @Column(name = "suitability_decision")
    private Boolean suitabilityDecision;

    @Column(name = "accumulation_value_minor")
    private Long accumulationValueMinor;

    @Column(name = "gmv_minor")
    private Long gmvMinor;

    @Column(name = "next_anniversary_date")
    private LocalDate nextAnniversaryDate;

    @Column(name = "cumulative_premium_minor")
    private Long cumulativePremiumMinor;

    @Column(name = "gmcsv_minor")
    private Long gmcsvMinor;

    public Policy() {
    }

    public UUID getPolicyId() {
        return policyId;
    }

    public void setPolicyId(UUID policyId) {
        this.policyId = policyId;
    }

    public UUID getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(UUID submissionId) {
        this.submissionId = submissionId;
    }

    public String getConfigVersion() {
        return configVersion;
    }

    public void setConfigVersion(String configVersion) {
        this.configVersion = configVersion;
    }

    public String getPolNumber() {
        return polNumber;
    }

    public void setPolNumber(String polNumber) {
        this.polNumber = polNumber;
    }

    public String getHoldingTypeCode() {
        return holdingTypeCode;
    }

    public void setHoldingTypeCode(String holdingTypeCode) {
        this.holdingTypeCode = holdingTypeCode;
    }

    public String getHoldingStatus() {
        return holdingStatus;
    }

    public void setHoldingStatus(String holdingStatus) {
        this.holdingStatus = holdingStatus;
    }

    public String getPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(String policyStatus) {
        this.policyStatus = policyStatus;
    }

    public String getLineOfBusiness() {
        return lineOfBusiness;
    }

    public void setLineOfBusiness(String lineOfBusiness) {
        this.lineOfBusiness = lineOfBusiness;
    }

    public String getCurrencyTypeCode() {
        return currencyTypeCode;
    }

    public void setCurrencyTypeCode(String currencyTypeCode) {
        this.currencyTypeCode = currencyTypeCode;
    }

    public String getIssueNation() {
        return issueNation;
    }

    public void setIssueNation(String issueNation) {
        this.issueNation = issueNation;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public String getCusipNum() {
        return cusipNum;
    }

    public void setCusipNum(String cusipNum) {
        this.cusipNum = cusipNum;
    }

    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    public String getCarrierCommCode() {
        return carrierCommCode;
    }

    public void setCarrierCommCode(String carrierCommCode) {
        this.carrierCommCode = carrierCommCode;
    }

    public BigDecimal getTotCommRetained() {
        return totCommRetained;
    }

    public void setTotCommRetained(BigDecimal totCommRetained) {
        this.totCommRetained = totCommRetained;
    }

    public String getDistributorClientAcctNum() {
        return distributorClientAcctNum;
    }

    public void setDistributorClientAcctNum(String distributorClientAcctNum) {
        this.distributorClientAcctNum = distributorClientAcctNum;
    }

    public BigDecimal getPolicyValue() {
        return policyValue;
    }

    public void setPolicyValue(BigDecimal policyValue) {
        this.policyValue = policyValue;
    }

    public String getQualPlanType() {
        return qualPlanType;
    }

    public void setQualPlanType(String qualPlanType) {
        this.qualPlanType = qualPlanType;
    }

    public BigDecimal getEeContribAmt() {
        return eeContribAmt;
    }

    public void setEeContribAmt(BigDecimal eeContribAmt) {
        this.eeContribAmt = eeContribAmt;
    }

    public BigDecimal getSurrenderCharge() {
        return surrenderCharge;
    }

    public void setSurrenderCharge(BigDecimal surrenderCharge) {
        this.surrenderCharge = surrenderCharge;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTerminationReason() {
        return terminationReason;
    }

    public void setTerminationReason(String terminationReason) {
        this.terminationReason = terminationReason;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public Boolean getSuitabilityDecision() {
        return suitabilityDecision;
    }

    public void setSuitabilityDecision(Boolean suitabilityDecision) {
        this.suitabilityDecision = suitabilityDecision;
    }

    public Long getAccumulationValueMinor() {
        return accumulationValueMinor;
    }

    public void setAccumulationValueMinor(Long accumulationValueMinor) {
        this.accumulationValueMinor = accumulationValueMinor;
    }

    public Long getGmvMinor() {
        return gmvMinor;
    }

    public void setGmvMinor(Long gmvMinor) {
        this.gmvMinor = gmvMinor;
    }

    public LocalDate getNextAnniversaryDate() {
        return nextAnniversaryDate;
    }

    public void setNextAnniversaryDate(LocalDate nextAnniversaryDate) {
        this.nextAnniversaryDate = nextAnniversaryDate;
    }

    public Long getCumulativePremiumMinor() {
        return cumulativePremiumMinor;
    }

    public void setCumulativePremiumMinor(Long cumulativePremiumMinor) {
        this.cumulativePremiumMinor = cumulativePremiumMinor;
    }

    public Long getGmcsvMinor() {
        return gmcsvMinor;
    }

    public void setGmcsvMinor(Long gmcsvMinor) {
        this.gmcsvMinor = gmcsvMinor;
    }

}
