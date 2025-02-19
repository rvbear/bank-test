package com.toss_bootcamp.test.domain.payment.bean.small;

import com.toss_bootcamp.test.domain.payment.domain.entity.PaymentDao;
import com.toss_bootcamp.test.domain.payment.repository.PaymentRepositoryJpa;
import org.springframework.stereotype.Component;

@Component
public class SavePaymentDaoBean {
    private final PaymentRepositoryJpa paymentRepositoryJpa;

    public SavePaymentDaoBean(PaymentRepositoryJpa paymentRepositoryJpa) {
        this.paymentRepositoryJpa = paymentRepositoryJpa;
    }

    public void exec(PaymentDao paymentDao) {
        paymentRepositoryJpa.save(paymentDao);
    }
}
