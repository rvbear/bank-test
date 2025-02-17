package com.toss_bootcamp.test.domain.account.bean.small;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class CreateAccountNumberBean {
    private final SecureRandom random = new SecureRandom();

    // 랜덤 계좌번호 생성
    public String exec() {
        int part1 = random.nextInt(9000) + 1000;
        int part2 = random.nextInt(9000) + 1000;
        int part3 = random.nextInt(9000) + 1000;

        return String.format("%4d-%4d-%4d", part1, part2, part3);
    }
}
