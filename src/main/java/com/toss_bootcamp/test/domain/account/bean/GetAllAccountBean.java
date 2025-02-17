package com.toss_bootcamp.test.domain.account.bean;

import com.toss_bootcamp.test.domain.account.bean.small.GetAllAccountDaoBean;
import com.toss_bootcamp.test.domain.account.domain.entity.AccountDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllAccountBean {
    private final GetAllAccountDaoBean getAllAccountDaoBean;

    public GetAllAccountBean(GetAllAccountDaoBean getAllAccountDaoBean) {
        this.getAllAccountDaoBean = getAllAccountDaoBean;
    }

    public List<AccountDao> exec() {
        return getAllAccountDaoBean.exec();
    }
}
