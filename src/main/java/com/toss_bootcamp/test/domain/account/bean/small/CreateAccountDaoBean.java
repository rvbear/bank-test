package com.toss_bootcamp.test.domain.account.bean.small;

import com.toss_bootcamp.test.domain.account.domain.entity.AccountDao;
import com.toss_bootcamp.test.domain.user.domain.entity.UserDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateAccountDaoBean {
    private final CreateAccountNumberBean createAccountNumberBean;

    public CreateAccountDaoBean(CreateAccountNumberBean createAccountNumberBean) {
        this.createAccountNumberBean = createAccountNumberBean;
    }

    // AccountDao 생성
    public AccountDao exec(UserDao userDao) {
        return AccountDao.builder()
                .accountId(UUID.randomUUID())
                .accountNumber(createAccountNumberBean.exec())
                .balance(0)
                .userId(userDao.getUserId())
                .build();
    }
}
