package com.prosperity.pas.policy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

/** JPA entity for policy.party_address (generated from the contract data model ERD). */
@Entity
@Table(schema = "policy", name = "party_address")
public class PartyAddress {

    @Id
    @Column(name = "address_id")
    private UUID addressId;

    @Column(name = "party_id")
    private UUID partyId;

    @Column(name = "address_type_code")
    private String addressTypeCode;

    @Column(name = "line1")
    private String line1;

    @Column(name = "city")
    private String city;

    @Column(name = "address_state_tc")
    private String addressStateTc;

    @Column(name = "zip")
    private String zip;

    @Column(name = "address_country_tc")
    private String addressCountryTc;

    public PartyAddress() {
    }

    public UUID getAddressId() {
        return addressId;
    }

    public void setAddressId(UUID addressId) {
        this.addressId = addressId;
    }

    public UUID getPartyId() {
        return partyId;
    }

    public void setPartyId(UUID partyId) {
        this.partyId = partyId;
    }

    public String getAddressTypeCode() {
        return addressTypeCode;
    }

    public void setAddressTypeCode(String addressTypeCode) {
        this.addressTypeCode = addressTypeCode;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressStateTc() {
        return addressStateTc;
    }

    public void setAddressStateTc(String addressStateTc) {
        this.addressStateTc = addressStateTc;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddressCountryTc() {
        return addressCountryTc;
    }

    public void setAddressCountryTc(String addressCountryTc) {
        this.addressCountryTc = addressCountryTc;
    }

}
