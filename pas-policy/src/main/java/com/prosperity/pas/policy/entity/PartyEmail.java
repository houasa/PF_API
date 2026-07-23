package com.prosperity.pas.policy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

/** JPA entity for policy.party_email (generated from the contract data model ERD). */
@Entity
@Table(schema = "policy", name = "party_email")
public class PartyEmail {

    @Id
    @Column(name = "email_id")
    private UUID emailId;

    @Column(name = "party_id")
    private UUID partyId;

    @Column(name = "email_type")
    private String emailType;

    @Column(name = "addr_line")
    private String addrLine;

    public PartyEmail() {
    }

    public UUID getEmailId() {
        return emailId;
    }

    public void setEmailId(UUID emailId) {
        this.emailId = emailId;
    }

    public UUID getPartyId() {
        return partyId;
    }

    public void setPartyId(UUID partyId) {
        this.partyId = partyId;
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    public String getAddrLine() {
        return addrLine;
    }

    public void setAddrLine(String addrLine) {
        this.addrLine = addrLine;
    }

}
