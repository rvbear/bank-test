package com.toss_bootcamp.test.domain.user.bean;

import com.toss_bootcamp.test.domain.user.bean.small.CreateUserDaoBean;
import com.toss_bootcamp.test.domain.user.bean.small.CreateUserDtoBean;
import com.toss_bootcamp.test.domain.user.bean.small.SaveUserDaoBean;
import com.toss_bootcamp.test.domain.user.domain.dto.RequestSignupDto;
import com.toss_bootcamp.test.domain.user.domain.dto.ResponseUserDto;
import com.toss_bootcamp.test.domain.user.domain.entity.UserDao;
import org.springframework.stereotype.Component;

@Component
public class CreateUserBean {
    private final CreateUserDaoBean createUserDaoBean;
    private final SaveUserDaoBean saveUserDaoBean;
    private final CreateUserDtoBean createUserDtoBean;

    public CreateUserBean(CreateUserDaoBean createUserDaoBean, SaveUserDaoBean saveUserDaoBean, CreateUserDtoBean createUserDtoBean) {
        this.createUserDaoBean = createUserDaoBean;
        this.saveUserDaoBean = saveUserDaoBean;
        this.createUserDtoBean = createUserDtoBean;
    }

    public ResponseUserDto exec(RequestSignupDto requestSignupDto) {
        UserDao userDao = createUserDaoBean.exec(requestSignupDto);
        saveUserDaoBean.exec(userDao);

        return createUserDtoBean.exec(userDao);
    }
}
