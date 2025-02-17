package com.toss_bootcamp.test.domain.account.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestUpdateAccountDto {
    String accountNumber;
    int money;
}
