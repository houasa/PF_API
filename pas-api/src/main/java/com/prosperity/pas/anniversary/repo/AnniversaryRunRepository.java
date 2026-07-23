package com.prosperity.pas.anniversary.repo;

import com.prosperity.pas.anniversary.entity.AnniversaryRun;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnniversaryRunRepository extends JpaRepository<AnniversaryRun, UUID> {
}
