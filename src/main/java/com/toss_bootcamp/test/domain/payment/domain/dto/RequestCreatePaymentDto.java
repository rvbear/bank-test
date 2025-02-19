package com.toss_bootcamp.test.domain.payment.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestCreatePaymentDto {
    String sendAccountNumber;
    String receiveAccountNumber;
    int money;
}
