package com.toss_bootcamp.test.domain.user.bean.small;

import com.toss_bootcamp.test.domain.user.domain.dto.RequestSignupDto;
import com.toss_bootcamp.test.domain.user.domain.entity.UserDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateUserDaoBean {
    public UserDao exec(RequestSignupDto requestSignupDto) {
        return UserDao.builder()
                .userId(UUID.randomUUID())
                .userName(requestSignupDto.getUserName())
                .passWord(requestSignupDto.getPassWord())
                .build();
    }
}
