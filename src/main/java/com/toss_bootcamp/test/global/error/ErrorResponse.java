package com.toss_bootcamp.test.global.error;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorResponse {
    String message;
    LocalDateTime time;
}
