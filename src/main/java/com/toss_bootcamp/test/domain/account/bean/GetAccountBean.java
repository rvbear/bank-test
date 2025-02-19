package com.toss_bootcamp.test.domain.account.bean;

import com.toss_bootcamp.test.domain.account.bean.small.GetAccountDaoBean;
import com.toss_bootcamp.test.domain.account.domain.entity.AccountDao;
import com.toss_bootcamp.test.global.error.CustomException;
import com.toss_bootcamp.test.global.error.ErrorCode;
import org.springframework.stereotype.Component;

@Component
public class GetAccountBean {
    private final GetAccountDaoBean getAccountDaoBean;

    public GetAccountBean(GetAccountDaoBean getAccountDaoBean) {
        this.getAccountDaoBean = getAccountDaoBean;
    }

    // 계좌 조회
    public AccountDao exec(String accountNumber) {
        AccountDao accountDao = getAccountDaoBean.exec(accountNumber);

        if (accountDao == null) {
            throw new CustomException(ErrorCode.ACCOUNT_NOT_FOUND);
        }

        return accountDao;
    }
}
