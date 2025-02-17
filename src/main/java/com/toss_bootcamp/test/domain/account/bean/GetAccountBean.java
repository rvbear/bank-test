package com.toss_bootcamp.test.domain.account.bean;

import com.toss_bootcamp.test.domain.account.bean.small.GetAccountDaoBean;
import com.toss_bootcamp.test.domain.account.domain.entity.AccountDao;
import org.springframework.stereotype.Component;

@Component
public class GetAccountBean {
    private final GetAccountDaoBean getAccountDaoBean;

    public GetAccountBean(GetAccountDaoBean getAccountDaoBean) {
        this.getAccountDaoBean = getAccountDaoBean;
    }

    // 계좌 조회
    public AccountDao exec(String accountNumber) {
        return getAccountDaoBean.exec(accountNumber);
    }
}
