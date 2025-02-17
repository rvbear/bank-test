package com.toss_bootcamp.test.domain.user.bean;

import com.toss_bootcamp.test.domain.user.bean.small.GetUsersDaoBean;
import com.toss_bootcamp.test.domain.user.domain.entity.UserDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetUsersBean {
    private final GetUsersDaoBean getUsersDaoBean;

    public GetUsersBean(GetUsersDaoBean getUsersDaoBean) {
        this.getUsersDaoBean = getUsersDaoBean;
    }

    public List<UserDao> exec() {
        return getUsersDaoBean.exec();
    }
}
