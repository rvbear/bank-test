package com.toss_bootcamp.test.domain.user.bean.small;

import com.toss_bootcamp.test.domain.user.domain.entity.UserDao;
import com.toss_bootcamp.test.domain.user.repository.UserRepositoryJpa;
import com.toss_bootcamp.test.global.error.CustomException;
import com.toss_bootcamp.test.global.error.ErrorCode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetUserDaoBean {
    private final UserRepositoryJpa userRepositoryJpa;

    public GetUserDaoBean(UserRepositoryJpa userRepositoryJpa) {
        this.userRepositoryJpa = userRepositoryJpa;
    }

    public UserDao exec(UUID userId) {
        return userRepositoryJpa.findById(userId).orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
    }
}
