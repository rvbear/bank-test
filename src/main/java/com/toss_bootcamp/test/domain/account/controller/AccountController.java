package com.toss_bootcamp.test.domain.account.controller;

import com.toss_bootcamp.test.domain.account.domain.dto.RequestCreateAccountDto;
import com.toss_bootcamp.test.domain.account.domain.dto.RequestTransferAccountDto;
import com.toss_bootcamp.test.domain.account.domain.dto.RequestUpdateAccountDto;
import com.toss_bootcamp.test.domain.account.domain.dto.ResponseAccountDto;
import com.toss_bootcamp.test.domain.account.domain.entity.AccountDao;
import com.toss_bootcamp.test.domain.account.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@Tag(name = "계좌 API", description = "계좌 관련 API")
@RequestMapping("/bank/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // 계좌 생성
    @Operation(summary = "계좌 생성", description = "계좌를 생성합니다.")
    @PostMapping("")
    public ResponseEntity<Map<String, Object>> createAccount(@RequestBody RequestCreateAccountDto requestCreateAccountDto) throws Exception {
        ResponseAccountDto responseAccountDto = accountService.createAccount(requestCreateAccountDto);

        boolean success = responseAccountDto != null;

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "계좌 생성 성공" : "계좌 생성 실패");
        requestMap.put("accountInfo", responseAccountDto);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 전체 계좌 조회
    @Operation(summary = "전체 계좌 조회", description = "모든 계좌를 조회합니다.")
    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllAccount() {
        List<AccountDao> responseAccountDaoList = accountService.getAllAccount();

        boolean success = !responseAccountDaoList.isEmpty();

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "모든 계좌 조회 성공" : "모든 계좌 조회 실패");
        requestMap.put("accountInfo", responseAccountDaoList);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 계좌 조회
    @Operation(summary = "계좌 조회", description = "계좌번호로 계좌를 조회합니다.")
    @GetMapping("/{accountNumber}")
    public ResponseEntity<Map<String, Object>> getAccount(@PathVariable("accountNumber") String accountNumber) {
        AccountDao accountDao = accountService.getAccount(accountNumber);

        boolean success = accountDao != null;

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "계좌 조회 성공" : "계좌 조회 실패");
        requestMap.put("accountInfo", accountDao);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 입금 & 출금
    @Operation(summary = "입/출금", description = "자신의 계좌에서 입/출금을 진행합니다.")
    @PutMapping("")
    public ResponseEntity<Map<String, Object>> updateAccount(@RequestBody RequestUpdateAccountDto requestUpdateAccountDto) {
        AccountDao accountDao = accountService.updateAccount(requestUpdateAccountDto);

        boolean success = accountDao != null;

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "입/출금 성공" : "입/출금 실패");
        requestMap.put("accountInfo", accountDao);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 송금
    @Operation(summary = "송금", description = "자신의 계좌에서 다른 계좌로 송금을 진행합니다.")
    @PostMapping("/transfer")
    public ResponseEntity<Map<String, Object>> transferAccount(@RequestBody RequestTransferAccountDto requestTransferAccountDto) {
        AccountDao accountDao = accountService.transferAccount(requestTransferAccountDto);

        boolean success = accountDao != null;

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "송금 성공" : "송금 실패");
        requestMap.put("accountInfo", accountDao);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }
}
