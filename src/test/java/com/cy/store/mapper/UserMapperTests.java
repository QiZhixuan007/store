package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;


@SpringBootTest
public class UserMapperTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert(){

        User user = new User();

        user.setUsername("hx11");

        user.setPassword("123");

        Integer flag = userMapper.insert(user);

        System.out.println("查询结果："+flag);
    }

    @Test
    public void find(){
        User user = userMapper.findByUsername("qz");
//        if(ObjectUtils.isEmpty(user))
        System.out.println("查询结果"+user.toString());
    }

    @Test
    public void updatePassword(){

        userMapper.updatePasswordByUid(
                1,
                "456",
                "qzx01",
                new Date());
    }

    @Test
    public void findByUid(){
        User user = userMapper.findByUid(2);
        System.out.println(user);
    }

    @Test
    public void updateUser(){
        User user = new User();
        user.setUid(1);
        user.setModifiedTime(new Date());
        user.setModifiedUser("爸爸");
        user.setEmail("1473841455@qq.com");
        user.setPhone("13630362636");
        user.setGender(1);
        userMapper.updateInfoByUid(user);
    }

    @Test
    public void updateAvatarByUid(){
        userMapper.updateAvatarByUid(
                1,
                "/123/23",
                "管理员",
                new Date());
    }
}
