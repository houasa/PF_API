package com.prosperity.pas.policy.repo;

import com.prosperity.pas.policy.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PolicyRepository extends JpaRepository<Policy, UUID> {
}
