package com.toss_bootcamp.test.domain.account.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class RequestCreateAccountDto {
    UUID userId;
}
