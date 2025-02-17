package com.toss_bootcamp.test.domain.account.bean;

import com.toss_bootcamp.test.domain.account.bean.small.CreateAccountDaoBean;
import com.toss_bootcamp.test.domain.account.bean.small.CreateAccountDtoBean;
import com.toss_bootcamp.test.domain.account.bean.small.SaveAccountDaoBean;
import com.toss_bootcamp.test.domain.account.domain.dto.RequestCreateAccountDto;
import com.toss_bootcamp.test.domain.account.domain.dto.ResponseAccountDto;
import com.toss_bootcamp.test.domain.account.domain.entity.AccountDao;
import com.toss_bootcamp.test.domain.user.bean.small.GetUserDaoBean;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class CreateAccountBean {
    private final GetUserDaoBean getUserDaoBean;
    private final CreateAccountDaoBean createAccountDaoBean;
    private final SaveAccountDaoBean saveAccountDaoBean;
    private final CreateAccountDtoBean createAccountDtoBean;

    public CreateAccountBean(GetUserDaoBean getUserDaoBean, CreateAccountDaoBean createAccountDaoBean, SaveAccountDaoBean saveAccountDaoBean, CreateAccountDtoBean createAccountDtoBean) {
        this.getUserDaoBean = getUserDaoBean;
        this.createAccountDaoBean = createAccountDaoBean;
        this.saveAccountDaoBean = saveAccountDaoBean;
        this.createAccountDtoBean = createAccountDtoBean;
    }

    // 계좌 개설
    public ResponseAccountDto exec(RequestCreateAccountDto requestCreateAccountDto) throws Exception {
        // 유저가 존재하는지 확인
        if (getUserDaoBean.exec(requestCreateAccountDto.getUserId()) == null) {
            throw new NoSuchElementException("존재하지 않는 유저입니다.");
        }

        // 새 계좌 개설
        AccountDao accountDao = createAccountDaoBean.exec(requestCreateAccountDto);
        saveAccountDaoBean.exec(accountDao);

        return createAccountDtoBean.exec(accountDao);
    }
}
