package com.prosperity.pas.policy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

/** JPA entity for policy.producer_of_record (generated from the contract data model ERD). */
@Entity
@Table(schema = "policy", name = "producer_of_record")
public class ProducerOfRecord {

    @Id
    @Column(name = "producer_row_id")
    private UUID producerRowId;

    @Column(name = "party_id")
    private UUID partyId;

    @Column(name = "nipr_number")
    private String niprNumber;

    @Column(name = "company_producer_id")
    private String companyProducerId;

    @Column(name = "company_producer_id_source")
    private String companyProducerIdSource;

    @Column(name = "carrier_appt_type_code")
    private String carrierApptTypeCode;

    public ProducerOfRecord() {
    }

    public UUID getProducerRowId() {
        return producerRowId;
    }

    public void setProducerRowId(UUID producerRowId) {
        this.producerRowId = producerRowId;
    }

    public UUID getPartyId() {
        return partyId;
    }

    public void setPartyId(UUID partyId) {
        this.partyId = partyId;
    }

    public String getNiprNumber() {
        return niprNumber;
    }

    public void setNiprNumber(String niprNumber) {
        this.niprNumber = niprNumber;
    }

    public String getCompanyProducerId() {
        return companyProducerId;
    }

    public void setCompanyProducerId(String companyProducerId) {
        this.companyProducerId = companyProducerId;
    }

    public String getCompanyProducerIdSource() {
        return companyProducerIdSource;
    }

    public void setCompanyProducerIdSource(String companyProducerIdSource) {
        this.companyProducerIdSource = companyProducerIdSource;
    }

    public String getCarrierApptTypeCode() {
        return carrierApptTypeCode;
    }

    public void setCarrierApptTypeCode(String carrierApptTypeCode) {
        this.carrierApptTypeCode = carrierApptTypeCode;
    }

}
