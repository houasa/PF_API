package com.prosperity.pas.anniversary.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/** Composite primary key for the index_value entity. */
public class IndexValueId implements Serializable {

    private String indexId;
    private LocalDate businessDate;

    public IndexValueId() {
    }

    public IndexValueId(String indexId, LocalDate businessDate) {
        this.indexId = indexId;
        this.businessDate = businessDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IndexValueId that)) return false;
        return Objects.equals(indexId, that.indexId) && Objects.equals(businessDate, that.businessDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(indexId, businessDate);
    }
}
