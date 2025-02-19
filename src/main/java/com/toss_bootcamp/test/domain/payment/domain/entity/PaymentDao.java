package com.toss_bootcamp.test.domain.payment.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PaymentDao {
    @Id
    UUID paymentId;

    String sendAccountNumber;
    String receiveAccountNumber;

    int money;
}
