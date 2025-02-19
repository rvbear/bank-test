package com.toss_bootcamp.test.domain.payment.controller;

import com.toss_bootcamp.test.domain.payment.domain.dto.RequestCreatePaymentDto;
import com.toss_bootcamp.test.domain.payment.domain.entity.PaymentDao;
import com.toss_bootcamp.test.domain.payment.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
@Tag(name = "거래내역 API", description = "거래내역 관련 API")
@RequestMapping("/bank/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // 송금하기
    @Operation(summary = "송금", description = "송금을 진행합니다.")
    @PostMapping("/transfer")
    public ResponseEntity<Map<String, Object>> createPayment(@RequestBody RequestCreatePaymentDto requestCreatePaymentDto) throws Exception {
        PaymentDao paymentDao = paymentService.createPayment(requestCreatePaymentDto);

        boolean success = paymentDao != null;

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("success", success);
        responseMap.put("message", success ? "송금 성공" : "송금 실패");
        responseMap.put("accountInfo", paymentDao);

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }

    // 거래 내역 조회하기
}
