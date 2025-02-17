package com.toss_bootcamp.test.domain.user.service;

import com.toss_bootcamp.test.domain.user.bean.CreateUserBean;
import com.toss_bootcamp.test.domain.user.bean.GetUsersBean;
import com.toss_bootcamp.test.domain.user.domain.dto.RequestSignupDto;
import com.toss_bootcamp.test.domain.user.domain.dto.ResponseUserDto;
import com.toss_bootcamp.test.domain.user.domain.entity.UserDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final CreateUserBean createUserBean;
    private final GetUsersBean getUsersBean;

    public UserService(CreateUserBean createUserBean, GetUsersBean getUsersBean) {
        this.createUserBean = createUserBean;
        this.getUsersBean = getUsersBean;
    }

    // 회원가입
    public ResponseUserDto signup(RequestSignupDto requestSignupDto) {
        return createUserBean.exec(requestSignupDto);
    }

    // 유저 전체조회
    public List<UserDao> getUserAll() {
        return getUsersBean.exec();
    }
}
