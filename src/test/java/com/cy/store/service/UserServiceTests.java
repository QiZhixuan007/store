package com.cy.store.service;

import com.cy.store.entity.User;
import com.cy.store.service.ex.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UserServiceTests {

    @Autowired
    private IUserService userService;

    @Test
    public void reg(){

        try {
            User user = new User();

            user.setUsername("hx123");

            user.setPassword("123");

            userService.reg(user);

            System.out.println("ok");

        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void login(){
        User user = userService.login("hx01","123");
        System.out.println(user.toString());
    }

    @Test
    public void changePassword(){
        userService.changePassword(13,"hX123","666666","123");
    }

    @Test
    public void getByUid(){
        User user = userService.getByUid(1);
        System.out.println(user);
    }

    @Test
    public void changeInfo(){
        User user = new User();
        user.setUsername("hx123");
        user.setPassword("123");
        user.setEmail("123456789");
        userService.changeInfo(2,"qzx",user);
    }

    @Test
    public void changeAvatar(){
        userService.changeAvatar(
                1,
                "/123/23/34/",
                "齐志轩");
    }
}




