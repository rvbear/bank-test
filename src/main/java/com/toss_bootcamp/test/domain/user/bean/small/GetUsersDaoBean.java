package com.toss_bootcamp.test.domain.user.bean.small;

import com.toss_bootcamp.test.domain.user.domain.entity.UserDao;
import com.toss_bootcamp.test.domain.user.repository.UserRepositoryJpa;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetUsersDaoBean {
    private final UserRepositoryJpa userRepositoryJpa;

    public GetUsersDaoBean(UserRepositoryJpa userRepositoryJpa) {
        this.userRepositoryJpa = userRepositoryJpa;
    }

    public List<UserDao> exec() {
        return userRepositoryJpa.findAll();
    }
}
