package com.prosperity.pas.anniversary.repo;

import com.prosperity.pas.anniversary.entity.IndexValue;
import com.prosperity.pas.anniversary.entity.IndexValueId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndexValueRepository extends JpaRepository<IndexValue, IndexValueId> {
}
