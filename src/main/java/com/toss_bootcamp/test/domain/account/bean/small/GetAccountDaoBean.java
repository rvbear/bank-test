package com.toss_bootcamp.test.domain.account.bean.small;

import com.toss_bootcamp.test.domain.account.domain.entity.AccountDao;
import com.toss_bootcamp.test.domain.account.repository.AccountRepositoryJpa;
import org.springframework.stereotype.Component;

@Component
public class GetAccountDaoBean {
    private final AccountRepositoryJpa accountRepositoryJpa;

    public GetAccountDaoBean(AccountRepositoryJpa accountRepositoryJpa) {
        this.accountRepositoryJpa = accountRepositoryJpa;
    }

    // 계좌번호로 조회
    public AccountDao exec(String accountNumber) {
        return accountRepositoryJpa.findByAccountNumber(accountNumber);
    }
}
