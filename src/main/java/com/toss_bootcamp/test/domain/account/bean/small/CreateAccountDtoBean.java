package com.toss_bootcamp.test.domain.account.bean.small;

import com.toss_bootcamp.test.domain.account.domain.dto.ResponseAccountDto;
import com.toss_bootcamp.test.domain.account.domain.entity.AccountDao;
import org.springframework.stereotype.Component;

@Component
public class CreateAccountDtoBean {
    // ResponseAccountDto 생성
    public ResponseAccountDto exec(AccountDao accountDao) {
        return ResponseAccountDto.builder()
                .accountId(accountDao.getAccountId())
                .accountNumber(accountDao.getAccountNumber())
                .balance(accountDao.getBalance())
                .userId(accountDao.getUserId())
                .build();
    }
}
