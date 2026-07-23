package com.prosperity.pas.policy.repo;

import com.prosperity.pas.policy.entity.PolicyAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PolicyAccountRepository extends JpaRepository<PolicyAccount, UUID> {
}
