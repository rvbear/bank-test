package com.toss_bootcamp.test.domain.account.bean.small;

import com.toss_bootcamp.test.domain.account.domain.entity.AccountDao;
import org.springframework.stereotype.Component;

@Component
public class UpdateAccountDaoBean {
    // 계좌 잔액 변경
    public AccountDao exec(AccountDao accountDao, int money) {
        int balance = accountDao.getBalance() + money;

        // 출금시 마이너스가 되면 출금 실패
        if (balance < 0) {
            return null;
        }

        accountDao.setBalance(balance);

        return accountDao;
    }
}
