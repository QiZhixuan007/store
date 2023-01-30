package com.cy.store.service.impl;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user) {

        String username = user.getUsername();

        User result = userMapper.findByUsername(username);

        if(result!=null){
            throw new UsernameDuplicatedException("用户名被占用");
        }

        String oldPassword = user.getPassword();
        String salt = UUID.randomUUID().toString().toUpperCase();
        user.setSalt(salt);
        String md5Password = getMD5Password(oldPassword, salt);
        user.setPassword(md5Password);
        user.setIsDelete(0);
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);
        Integer rows = userMapper.insert(user);
        if(rows!=1){
            throw new InsertException("用户注册过程中产生未知异常");
        }
    }

    @Override
    public User login(String username, String password){
        User result = userMapper.findByUsername(username);
        if(result == null){
            throw new UserNotFoundException("用户不存在");
        }
        String salt = result.getSalt();
        String oldPassword = result.getPassword();
        String MD5Password = getMD5Password(password, salt);
        if(!MD5Password.equals(oldPassword)){
            throw new PasswordNotMatchException("密码错误");
        }
        if(result.getIsDelete() == 1) {
            throw new UserNotFoundException("用户名已注销");
        }
        User user = new User();
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setAvatar(result.getAvatar());
        return user;
    }

    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {
        User result = userMapper.findByUid(uid);
        if(result == null||result.getIsDelete() == 1){
            throw new UserNotFoundException("用户数据不存在");
        }
        String oldMD5Password = getMD5Password(oldPassword, result.getSalt());
        if(!oldMD5Password.equals(result.getPassword())){
            throw new PasswordNotMatchException("密码错误");
        }
        String newMD5Password = getMD5Password(newPassword, result.getSalt());
        Date date = new Date();
        Integer rows = userMapper.updatePasswordByUid(uid, newMD5Password, username, date);
        if(rows != 1){
            throw new UpdateException("更新数据产生未知异常");
        }
    }

    @Override
    public User getByUid(Integer uid) {
        User result = userMapper.findByUid(uid);
        if(result == null||result.getIsDelete() == 1){
            throw new UserNotFoundException("用户数据不存在");
        }
        User user = new User();
        user.setUsername(result.getUsername());
        user.setPhone(result.getPhone());
        user.setEmail(result.getEmail());
        user.setGender(result.getGender());
        return user;
    }

    @Override
    public void changeInfo(Integer uid, String username, User user) {
        User result = userMapper.findByUid(uid);
        if(result == null || result.getIsDelete() == 1){
            throw new UserNotFoundException("用户数据不存在");
        }
        user.setUid(uid);
        user.setUsername(username);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());

        Integer rows = userMapper.updateInfoByUid(user);
        if(rows != 1){
            throw new UpdateException("更新数据时产生未知异常");
        }
    }

    @Override
    public void changeAvatar(Integer uid, String avatar, String username) {
        User result = userMapper.findByUid(uid);
        if(result == null || result.getIsDelete() == 1){
            throw new UserNotFoundException("用户数据不存在");
        }
        Integer rows = userMapper.updateAvatarByUid(uid, avatar, username, new Date());
        if(rows != 1){
            throw new UpdateException("更新用户头像产生未知异常");
        }
    }

    private String getMD5Password(String password, String salt){
        for(int i = 0; i < 3; i++){
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        return password;
    }
}
