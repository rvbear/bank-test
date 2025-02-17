package com.toss_bootcamp.test.domain.user.controller;

import com.toss_bootcamp.test.domain.user.domain.dto.RequestSignupDto;
import com.toss_bootcamp.test.domain.user.domain.dto.ResponseUserDto;
import com.toss_bootcamp.test.domain.user.domain.entity.UserDao;
import com.toss_bootcamp.test.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@RestController
@Tag(name = "유저 API", description = "유저 관련 API")
@CrossOrigin("*")
@RequestMapping("/bank/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원가입
    @Operation(summary = "회원가입", description = "회원가입을 진행합니다.")
    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> signup(@RequestBody RequestSignupDto requestSignupDto) {
        ResponseUserDto responseUserDto = userService.signup(requestSignupDto);

        boolean success = responseUserDto != null;

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "회원가입 성공" : "회원가입 실패");
        requestMap.put("userInfo", responseUserDto);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 유저 전체조회
    @Operation(summary = "유저 전체조회", description = "가입된 전체 유저의 정보를 가져옵니다.")
    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getUserAll() {
        List<UserDao> responseUserDaoList = userService.getUserAll();

        boolean success = !responseUserDaoList.isEmpty();

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "유저 전체조회 성공" : "유저 전체조회 실패");
        requestMap.put("userList", responseUserDaoList);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }
}
