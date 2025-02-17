package com.toss_bootcamp.test.domain.account.domain.entity;

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
public class AccountDao {
    @Id
    UUID accountId;

    String accountNumber;
    int balance;

    UUID userId;
}
