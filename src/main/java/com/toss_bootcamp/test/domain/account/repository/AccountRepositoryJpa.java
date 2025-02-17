package com.toss_bootcamp.test.domain.account.repository;

import com.toss_bootcamp.test.domain.account.domain.entity.AccountDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepositoryJpa extends JpaRepository<AccountDao, UUID> {
    AccountDao findByAccountNumber(String accountNumber);
}
