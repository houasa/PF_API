package com.prosperity.pas.anniversary.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/** JPA entity for anniversary.index_value (generated from the contract data model ERD). */
@Entity
@Table(schema = "anniversary", name = "index_value")
@IdClass(IndexValueId.class)
public class IndexValue {

    @Id
    @Column(name = "index_id")
    private String indexId;

    @Id
    @Column(name = "business_date")
    private LocalDate businessDate;

    @Column(name = "close_value")
    private BigDecimal closeValue;

    @Column(name = "published_at")
    private LocalDateTime publishedAt;

    @Column(name = "source")
    private String source;

    @Column(name = "selection_note")
    private String selectionNote;

    public IndexValue() {
    }

    public String getIndexId() {
        return indexId;
    }

    public void setIndexId(String indexId) {
        this.indexId = indexId;
    }

    public LocalDate getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(LocalDate businessDate) {
        this.businessDate = businessDate;
    }

    public BigDecimal getCloseValue() {
        return closeValue;
    }

    public void setCloseValue(BigDecimal closeValue) {
        this.closeValue = closeValue;
    }

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDateTime publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSelectionNote() {
        return selectionNote;
    }

    public void setSelectionNote(String selectionNote) {
        this.selectionNote = selectionNote;
    }

}
