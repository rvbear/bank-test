package com.toss_bootcamp.test.domain.account.bean;

import com.toss_bootcamp.test.domain.account.bean.small.GetAccountDaoBean;
import com.toss_bootcamp.test.domain.account.bean.small.SaveAccountDaoBean;
import com.toss_bootcamp.test.domain.account.bean.small.UpdateAccountDaoBean;
import com.toss_bootcamp.test.domain.account.domain.dto.RequestTransferAccountDto;
import com.toss_bootcamp.test.domain.account.domain.dto.RequestUpdateAccountDto;
import com.toss_bootcamp.test.domain.account.domain.entity.AccountDao;
import org.springframework.stereotype.Component;

@Component
public class UpdateAccountBean {
    private final GetAccountDaoBean getAccountDaoBean;
    private final UpdateAccountDaoBean updateAccountDaoBean;
    private final SaveAccountDaoBean saveAccountDaoBean;

    public UpdateAccountBean(GetAccountDaoBean getAccountDaoBean, UpdateAccountDaoBean updateAccountDaoBean, SaveAccountDaoBean saveAccountDaoBean) {
        this.getAccountDaoBean = getAccountDaoBean;
        this.updateAccountDaoBean = updateAccountDaoBean;
        this.saveAccountDaoBean = saveAccountDaoBean;
    }

    // 입금, 출금
    public AccountDao exec(RequestUpdateAccountDto requestUpdateAccountDto) {
        AccountDao accountDao = getAccountDaoBean.exec(requestUpdateAccountDto.getAccountNumber());
        AccountDao updateAccountDao = updateAccountDaoBean.exec(accountDao, requestUpdateAccountDto.getMoney());

        if (updateAccountDao == null) {
            return null;
        }

        saveAccountDaoBean.exec(updateAccountDao);

        return updateAccountDao;
    }

    // 송금
    public AccountDao exec(RequestTransferAccountDto requestTransferAccountDto) {
        // 송신인과 수신인의 계좌를 불러옴
        AccountDao sendAccountDao = getAccountDaoBean.exec(requestTransferAccountDto.getSendAccountNumber());
        AccountDao receiveAccountDao = getAccountDaoBean.exec(requestTransferAccountDto.getReceiveAccountNumber());

        // 하나라도 계좌가 존재하지 않을 경우 실패
        if (sendAccountDao == null || receiveAccountDao == null) {
            return null;
        }

        // 각각의 계좌에서 입출금 진행
        AccountDao updateSendAccountDao = updateAccountDaoBean.exec(sendAccountDao, requestTransferAccountDto.getMoney() * (-1));
        AccountDao updateReceiveAccountDao = updateAccountDaoBean.exec(receiveAccountDao, requestTransferAccountDto.getMoney());

        // 하나라도 실패했을 시 실패
        if (updateSendAccountDao == null || updateReceiveAccountDao == null) {
            return null;
        }

        saveAccountDaoBean.exec(updateSendAccountDao);
        saveAccountDaoBean.exec(updateReceiveAccountDao);

        return updateSendAccountDao;
    }
}
