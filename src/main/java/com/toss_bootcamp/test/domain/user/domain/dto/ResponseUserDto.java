package com.toss_bootcamp.test.domain.user.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ResponseUserDto {
    UUID userId;
    String userName;
}
