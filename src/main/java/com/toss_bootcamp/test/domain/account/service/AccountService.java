package com.toss_bootcamp.test.domain.account.service;

import com.toss_bootcamp.test.domain.account.bean.CreateAccountBean;
import com.toss_bootcamp.test.domain.account.bean.GetAccountBean;
import com.toss_bootcamp.test.domain.account.bean.GetAllAccountBean;
import com.toss_bootcamp.test.domain.account.bean.UpdateAccountBean;
import com.toss_bootcamp.test.domain.account.domain.dto.RequestCreateAccountDto;
import com.toss_bootcamp.test.domain.account.domain.dto.RequestTransferAccountDto;
import com.toss_bootcamp.test.domain.account.domain.dto.RequestUpdateAccountDto;
import com.toss_bootcamp.test.domain.account.domain.dto.ResponseAccountDto;
import com.toss_bootcamp.test.domain.account.domain.entity.AccountDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final CreateAccountBean createAccountBean;
    private final GetAllAccountBean getAllAccountBean;
    private final GetAccountBean getAccountBean;
    private final UpdateAccountBean updateAccountBean;

    public AccountService(CreateAccountBean createAccountBean, GetAllAccountBean getAllAccountBean, GetAccountBean getAccountBean, UpdateAccountBean updateAccountBean) {
        this.createAccountBean = createAccountBean;
        this.getAllAccountBean = getAllAccountBean;
        this.getAccountBean = getAccountBean;
        this.updateAccountBean = updateAccountBean;
    }

    // 계좌 생성
    public ResponseAccountDto createAccount(RequestCreateAccountDto requestCreateAccountDto) throws Exception {
        return createAccountBean.exec(requestCreateAccountDto);
    }

    // 전체 계좌 조회
    public List<AccountDao> getAllAccount() {
        return getAllAccountBean.exec();
    }

    // 계좌번호로 계좌 조회
    public AccountDao getAccount(String accountNumber) {
        return getAccountBean.exec(accountNumber);
    }

    // 입/출금
    public AccountDao updateAccount(RequestUpdateAccountDto requestUpdateAccountDto) {
        return updateAccountBean.exec(requestUpdateAccountDto);
    }

    // 송금
    public AccountDao transferAccount(RequestTransferAccountDto requestTransferAccountDto) {
        return updateAccountBean.exec(requestTransferAccountDto);
    }
}
