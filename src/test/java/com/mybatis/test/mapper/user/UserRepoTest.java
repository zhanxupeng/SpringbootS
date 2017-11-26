package com.mybatis.test.mapper.user;

import com.mybatis.test.TestApplicationTests;
import com.mybatis.test.model.User;
import com.mybatis.test.repo.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

/**
 * Created by 占大帅 on 2017/11/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationTests.class)
public class UserRepoTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void testGetUserByUsername() {
        //Arrange
        String username = "zhan";

        //Act
        User user = userMapper.selectByUsername(username);

        //Assert
        assertEquals(1, user.getId());
        assertEquals("zhan", user.getUsername());
        assertEquals("zhan123456", user.getPassword());
    }
}
