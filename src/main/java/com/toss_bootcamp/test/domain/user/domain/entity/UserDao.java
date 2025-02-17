package com.toss_bootcamp.test.domain.user.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDao {
    @Id
    UUID userId;

    String userName;
    String passWord;
}
