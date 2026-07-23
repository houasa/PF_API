package com.prosperity.pas.policy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

/** JPA entity for policy.party_phone (generated from the contract data model ERD). */
@Entity
@Table(schema = "policy", name = "party_phone")
public class PartyPhone {

    @Id
    @Column(name = "phone_id")
    private UUID phoneId;

    @Column(name = "party_id")
    private UUID partyId;

    @Column(name = "phone_type_code")
    private String phoneTypeCode;

    @Column(name = "area_code")
    private String areaCode;

    @Column(name = "dial_number")
    private String dialNumber;

    public PartyPhone() {
    }

    public UUID getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(UUID phoneId) {
        this.phoneId = phoneId;
    }

    public UUID getPartyId() {
        return partyId;
    }

    public void setPartyId(UUID partyId) {
        this.partyId = partyId;
    }

    public String getPhoneTypeCode() {
        return phoneTypeCode;
    }

    public void setPhoneTypeCode(String phoneTypeCode) {
        this.phoneTypeCode = phoneTypeCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getDialNumber() {
        return dialNumber;
    }

    public void setDialNumber(String dialNumber) {
        this.dialNumber = dialNumber;
    }

}
