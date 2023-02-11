package com.jie;

import com.jie.mapper.NewsMapper;
import com.jie.mapper.UserMapper;
import com.jie.pojo.User;
import com.jie.pojo.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NewsBackStateApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Autowired
    NewsMapper newsMapper;

    @Test
    void queryNewsMostOftenTest() {
        System.out.println(newsMapper.queryNewsMostOften());
    }

    @Test
    void queryUserListTest() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword(123456);
        user.setRoleState(1);
        System.out.println(user);
        System.out.println(userMapper.queryUserList(user));
    }

}
