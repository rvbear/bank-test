package com.toss_bootcamp.test.domain.payment.service;

import com.toss_bootcamp.test.domain.payment.bean.CreatePaymentBean;
import com.toss_bootcamp.test.domain.payment.domain.dto.RequestCreatePaymentDto;
import com.toss_bootcamp.test.domain.payment.domain.entity.PaymentDao;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final CreatePaymentBean createPaymentBean;

    public PaymentService(CreatePaymentBean createPaymentBean) {
        this.createPaymentBean = createPaymentBean;
    }

    // 송금하기
    public PaymentDao createPayment(RequestCreatePaymentDto requestCreatePaymentDto) throws Exception {
        return createPaymentBean.exec(requestCreatePaymentDto);
    }
}
