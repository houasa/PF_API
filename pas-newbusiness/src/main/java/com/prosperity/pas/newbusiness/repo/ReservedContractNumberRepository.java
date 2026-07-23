package com.prosperity.pas.newbusiness.repo;

import com.prosperity.pas.newbusiness.entity.ReservedContractNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReservedContractNumberRepository extends JpaRepository<ReservedContractNumber, UUID> {
}
