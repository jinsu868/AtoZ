package com.AtoZ.abc.repository;

import com.AtoZ.abc.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserRepositoryTest {

    @Autowired
    public UserRepository userRepository;

    @Test
    void 기능테스트() {
        User user = new User();
        user.setLoginId("atoz");

        userRepository.save(user);

    }


}