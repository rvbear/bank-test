package com.toss_bootcamp.test.domain.user.bean.small;

import com.toss_bootcamp.test.domain.user.domain.dto.ResponseUserDto;
import com.toss_bootcamp.test.domain.user.domain.entity.UserDao;
import org.springframework.stereotype.Component;

@Component
public class CreateUserDtoBean {
    public ResponseUserDto exec(UserDao userDao) {
        return ResponseUserDto.builder()
                .userId(userDao.getUserId())
                .userName(userDao.getUserName())
                .build();
    }
}
