package com.toss_bootcamp.test.domain.user.repository;

import com.toss_bootcamp.test.domain.user.domain.entity.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepositoryJpa extends JpaRepository<UserDao, UUID> {
}
