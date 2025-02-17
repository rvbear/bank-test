package com.toss_bootcamp.test.domain.account.bean.small;

import com.toss_bootcamp.test.domain.account.domain.entity.AccountDao;
import com.toss_bootcamp.test.domain.account.repository.AccountRepositoryJpa;
import org.springframework.stereotype.Component;

@Component
public class SaveAccountDaoBean {
    private final AccountRepositoryJpa accountRepositoryJpa;

    public SaveAccountDaoBean(AccountRepositoryJpa accountRepositoryJpa) {
        this.accountRepositoryJpa = accountRepositoryJpa;
    }

    // AccountDao 저장
    public void exec(AccountDao accountDao) {
        accountRepositoryJpa.save(accountDao);
    }
}
