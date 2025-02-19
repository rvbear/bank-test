package com.toss_bootcamp.test.domain.payment.bean.small;

import com.toss_bootcamp.test.domain.payment.domain.dto.RequestCreatePaymentDto;
import com.toss_bootcamp.test.domain.payment.domain.entity.PaymentDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreatePaymentDaoBean {
    public PaymentDao exec(RequestCreatePaymentDto requestCreatePaymentDto) {
        return PaymentDao.builder()
                .paymentId(UUID.randomUUID())
                .sendAccountNumber(requestCreatePaymentDto.getSendAccountNumber())
                .receiveAccountNumber(requestCreatePaymentDto.getReceiveAccountNumber())
                .money(requestCreatePaymentDto.getMoney())
                .build();
    }
}
