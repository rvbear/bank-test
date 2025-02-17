package com.toss_bootcamp.test.domain.user.bean.small;

import com.toss_bootcamp.test.domain.user.domain.entity.UserDao;
import com.toss_bootcamp.test.domain.user.repository.UserRepositoryJpa;
import org.springframework.stereotype.Component;

@Component
public class SaveUserDaoBean {
    private final UserRepositoryJpa userRepositoryJpa;

    public SaveUserDaoBean(UserRepositoryJpa userRepositoryJpa) {
        this.userRepositoryJpa = userRepositoryJpa;
    }

    public void exec(UserDao userDao) {
        userRepositoryJpa.save(userDao);
    }
}
