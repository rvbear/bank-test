package com.toss_bootcamp.test.domain.payment.bean;

import com.toss_bootcamp.test.domain.account.bean.small.GetAccountDaoBean;
import com.toss_bootcamp.test.domain.account.bean.small.SaveAccountDaoBean;
import com.toss_bootcamp.test.domain.account.bean.small.UpdateAccountDaoBean;
import com.toss_bootcamp.test.domain.account.domain.entity.AccountDao;
import com.toss_bootcamp.test.domain.payment.bean.small.CreatePaymentDaoBean;
import com.toss_bootcamp.test.domain.payment.bean.small.SavePaymentDaoBean;
import com.toss_bootcamp.test.domain.payment.domain.dto.RequestCreatePaymentDto;
import com.toss_bootcamp.test.domain.payment.domain.entity.PaymentDao;
import com.toss_bootcamp.test.global.error.CustomException;
import com.toss_bootcamp.test.global.error.ErrorCode;
import org.springframework.stereotype.Component;

@Component
public class CreatePaymentBean {
    private final GetAccountDaoBean getAccountDaoBean;
    private final UpdateAccountDaoBean updateAccountDaoBean;
    private final SaveAccountDaoBean saveAccountDaoBean;
    private final CreatePaymentDaoBean createPaymentDaoBean;
    private final SavePaymentDaoBean savePaymentDaoBean;

    public CreatePaymentBean(GetAccountDaoBean getAccountDaoBean, UpdateAccountDaoBean updateAccountDaoBean, SaveAccountDaoBean saveAccountDaoBean, CreatePaymentDaoBean createPaymentDaoBean, SavePaymentDaoBean savePaymentDaoBean) {
        this.getAccountDaoBean = getAccountDaoBean;
        this.updateAccountDaoBean = updateAccountDaoBean;
        this.saveAccountDaoBean = saveAccountDaoBean;
        this.createPaymentDaoBean = createPaymentDaoBean;
        this.savePaymentDaoBean = savePaymentDaoBean;
    }

    // 거래내역 생성하기
    public PaymentDao exec(RequestCreatePaymentDto requestCreatePaymentDto) throws CustomException {
        AccountDao sendAccount = getAccountDaoBean.exec(requestCreatePaymentDto.getSendAccountNumber());
        AccountDao receiveAccount = getAccountDaoBean.exec(requestCreatePaymentDto.getReceiveAccountNumber());

        // 송금 계좌 혹은 송신 계좌가 존재하지 않는 경우
        if (sendAccount == null || receiveAccount == null) {
            throw new CustomException(ErrorCode.ACCOUNT_NOT_FOUND);
        }

        AccountDao updateSendAccount = updateAccountDaoBean.exec(sendAccount, requestCreatePaymentDto.getMoney() * -1);
        AccountDao updateReceiveAccount = updateAccountDaoBean.exec(receiveAccount, requestCreatePaymentDto.getMoney());

        // 올바른 입금/출금이 진행되지 못한 경우
        if (updateSendAccount == null || updateReceiveAccount == null) {
            throw new CustomException(ErrorCode.INSUFFICIENT_BALANCE);
        }

        PaymentDao paymentDao = createPaymentDaoBean.exec(requestCreatePaymentDto);

        saveAccountDaoBean.exec(updateSendAccount);
        saveAccountDaoBean.exec(updateReceiveAccount);
        savePaymentDaoBean.exec(paymentDao);

        return paymentDao;
    }
}
