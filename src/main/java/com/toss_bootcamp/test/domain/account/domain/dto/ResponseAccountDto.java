package com.toss_bootcamp.test.domain.account.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ResponseAccountDto {
    UUID accountId;
    String accountNumber;
    int balance;
    UUID userId;
}
