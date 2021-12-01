package com.example.demo;
import com.example.demo.dao.IUserDao;
import com.example.demo.entity.User;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class UserDaoTest {
    @Autowired
    private IUserDao userDao;
}
