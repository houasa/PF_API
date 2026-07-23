package com.prosperity.pas.newbusiness.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

/** JPA entity for newbusiness.nb_submission (generated from the contract data model ERD). */
@Entity
@Table(schema = "newbusiness", name = "nb_submission")
public class NbSubmission {

    @Id
    @Column(name = "submission_id")
    private UUID submissionId;

    @Column(name = "trans_ref_guid")
    private String transRefGuid;

    @Column(name = "trans_type")
    private String transType;

    @Column(name = "trans_sub_type")
    private String transSubType;

    @Column(name = "trans_exe_date")
    private LocalDate transExeDate;

    @Column(name = "trans_exe_time")
    private LocalTime transExeTime;

    @Column(name = "trans_mode")
    private String transMode;

    @Column(name = "test_indicator")
    private String testIndicator;

    @Column(name = "vendor_name")
    private String vendorName;

    @Column(name = "ho_assigned_app_number")
    private String hoAssignedAppNumber;

    @Column(name = "tracking_id")
    private String trackingId;

    @Column(name = "application_type")
    private String applicationType;

    @Column(name = "application_jurisdiction")
    private String applicationJurisdiction;

    @Column(name = "application_country")
    private String applicationCountry;

    @Column(name = "signed_date")
    private LocalDate signedDate;

    @Column(name = "submission_date")
    private LocalDate submissionDate;

    @Column(name = "submission_type")
    private String submissionType;

    @Column(name = "application_signature_type")
    private String applicationSignatureType;

    @Column(name = "application_signed_state")
    private String applicationSignedState;

    @Column(name = "associated_firm_id")
    private String associatedFirmId;

    public NbSubmission() {
    }

    public UUID getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(UUID submissionId) {
        this.submissionId = submissionId;
    }

    public String getTransRefGuid() {
        return transRefGuid;
    }

    public void setTransRefGuid(String transRefGuid) {
        this.transRefGuid = transRefGuid;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getTransSubType() {
        return transSubType;
    }

    public void setTransSubType(String transSubType) {
        this.transSubType = transSubType;
    }

    public LocalDate getTransExeDate() {
        return transExeDate;
    }

    public void setTransExeDate(LocalDate transExeDate) {
        this.transExeDate = transExeDate;
    }

    public LocalTime getTransExeTime() {
        return transExeTime;
    }

    public void setTransExeTime(LocalTime transExeTime) {
        this.transExeTime = transExeTime;
    }

    public String getTransMode() {
        return transMode;
    }

    public void setTransMode(String transMode) {
        this.transMode = transMode;
    }

    public String getTestIndicator() {
        return testIndicator;
    }

    public void setTestIndicator(String testIndicator) {
        this.testIndicator = testIndicator;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getHoAssignedAppNumber() {
        return hoAssignedAppNumber;
    }

    public void setHoAssignedAppNumber(String hoAssignedAppNumber) {
        this.hoAssignedAppNumber = hoAssignedAppNumber;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public String getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

    public String getApplicationJurisdiction() {
        return applicationJurisdiction;
    }

    public void setApplicationJurisdiction(String applicationJurisdiction) {
        this.applicationJurisdiction = applicationJurisdiction;
    }

    public String getApplicationCountry() {
        return applicationCountry;
    }

    public void setApplicationCountry(String applicationCountry) {
        this.applicationCountry = applicationCountry;
    }

    public LocalDate getSignedDate() {
        return signedDate;
    }

    public void setSignedDate(LocalDate signedDate) {
        this.signedDate = signedDate;
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getSubmissionType() {
        return submissionType;
    }

    public void setSubmissionType(String submissionType) {
        this.submissionType = submissionType;
    }

    public String getApplicationSignatureType() {
        return applicationSignatureType;
    }

    public void setApplicationSignatureType(String applicationSignatureType) {
        this.applicationSignatureType = applicationSignatureType;
    }

    public String getApplicationSignedState() {
        return applicationSignedState;
    }

    public void setApplicationSignedState(String applicationSignedState) {
        this.applicationSignedState = applicationSignedState;
    }

    public String getAssociatedFirmId() {
        return associatedFirmId;
    }

    public void setAssociatedFirmId(String associatedFirmId) {
        this.associatedFirmId = associatedFirmId;
    }

}
