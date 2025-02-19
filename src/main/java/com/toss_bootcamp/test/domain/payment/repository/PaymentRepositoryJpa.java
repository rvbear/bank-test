package com.toss_bootcamp.test.domain.payment.repository;

import com.toss_bootcamp.test.domain.payment.domain.entity.PaymentDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepositoryJpa extends JpaRepository<PaymentDao, UUID> {
}
