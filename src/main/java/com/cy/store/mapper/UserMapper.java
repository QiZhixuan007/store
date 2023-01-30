package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface UserMapper {

    /**
     * 插入用户数据
     * @param user
     * @return 成功为1，失败为0
     */
    Integer insert(User user);

    /**
     * 查询用户数据
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 根据uid修改密码
     * @param uid
     * @param password
     * @param modifiedUser
     * @param modifiedTime
     * @return
     */
    Integer updatePasswordByUid(@Param("uid") Integer uid,
                                @Param("password") String password,
                                @Param("modifiedUser") String modifiedUser,
                                @Param("modifiedTime") Date modifiedTime);

    /**
     * 根据uid查找用户
     * @param uid
     * @return
     */
    User findByUid(Integer uid);

    /**
     * 更新用户的数据信息
     * @param user
     * @return
     */
    Integer updateInfoByUid(User user);

    /**
     * 上传照片
     * @param uid
     * @param avatar
     * @param modifiedUser
     * @param modifiedTime
     * @return
     */
    Integer updateAvatarByUid(@Param("uid") Integer uid,
                              @Param("avatar") String avatar,
                              @Param("modifiedUser") String modifiedUser,
                              @Param("modifiedTime") Date modifiedTime);
}
