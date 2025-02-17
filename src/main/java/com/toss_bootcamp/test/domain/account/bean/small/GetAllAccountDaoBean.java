package com.toss_bootcamp.test.domain.account.bean.small;

import com.toss_bootcamp.test.domain.account.domain.entity.AccountDao;
import com.toss_bootcamp.test.domain.account.repository.AccountRepositoryJpa;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllAccountDaoBean {
    private final AccountRepositoryJpa accountRepositoryJpa;

    public GetAllAccountDaoBean(AccountRepositoryJpa accountRepositoryJpa) {
        this.accountRepositoryJpa = accountRepositoryJpa;
    }

    public List<AccountDao> exec() {
        return accountRepositoryJpa.findAll();
    }
}
