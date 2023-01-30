package com.cy.store.service;

import com.cy.store.entity.User;

public interface IUserService {
    /**
     * 注册
     * @param user
     */
    void reg(User user);

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);

    /**
     *
     * 修改用户密码
     * @param uid
     * @param username
     * @param oldPassword
     * @param newPassword
     */
    void changePassword(Integer uid,
                        String username,
                        String oldPassword,
                        String newPassword);

    /**
     * 根据用户的id查找用户数据
     * @param uid
     * @return
     */
    User getByUid(Integer uid);

    /**
     * 修改用户的信息
     * @param uid
     * @param username
     * @param user
     */
    void changeInfo(Integer uid, String username, User user);

    /**
     * 修改用户头像
     * @param uid
     * @param avatar
     * @param username
     */
    void changeAvatar(Integer uid, String avatar, String username);
}
