package com.prosperity.pas.policy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

/** JPA entity for policy.party (generated from the contract data model ERD). */
@Entity
@Table(schema = "policy", name = "party")
public class Party {

    @Id
    @Column(name = "party_id")
    private UUID partyId;

    @Column(name = "party_type_code")
    private String partyTypeCode;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "org_name")
    private String orgName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "govt_id")
    private String govtId;

    @Column(name = "govt_id_tc")
    private String govtIdTc;

    @Column(name = "org_form")
    private String orgForm;

    public Party() {
    }

    public UUID getPartyId() {
        return partyId;
    }

    public void setPartyId(UUID partyId) {
        this.partyId = partyId;
    }

    public String getPartyTypeCode() {
        return partyTypeCode;
    }

    public void setPartyTypeCode(String partyTypeCode) {
        this.partyTypeCode = partyTypeCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGovtId() {
        return govtId;
    }

    public void setGovtId(String govtId) {
        this.govtId = govtId;
    }

    public String getGovtIdTc() {
        return govtIdTc;
    }

    public void setGovtIdTc(String govtIdTc) {
        this.govtIdTc = govtIdTc;
    }

    public String getOrgForm() {
        return orgForm;
    }

    public void setOrgForm(String orgForm) {
        this.orgForm = orgForm;
    }

}
