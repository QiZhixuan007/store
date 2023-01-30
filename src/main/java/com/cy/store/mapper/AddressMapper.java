package com.cy.store.mapper;

import com.cy.store.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AddressMapper {

    /**
     * 插入用户的收获地址数据
     * @param address
     * @return 受影响行数
     */
    Integer insert(Address address);

    /**
     * 根据用户的uid统计地址数量
     * @param uid
     * @return
     */
    Integer countByUid(Integer uid);

    /**
     * 根据用户的id查询用户的收货地址数据
     * @param uid
     * @return
     */
    List<Address> findByUid(@Param("uid") Integer uid);

    /**
     * 根据aid查询收获地址数据
     * @param aid
     * @return
     */
    Address findByAid(Integer aid);

    Integer updateNonDefault(Integer uid);

    Integer updateDefaultByAid(@Param("aid") Integer aid,
                               @Param("modifiedUser") String modifiedUser,
                               @Param("modifiedTime") Date modifiedTime);

    /**
     * 根据收货地址aid删除地址数据
     * @param aid
     * @return
     */
    Integer deleteByAid(Integer aid);

    /**
     * 查询最新收货地址
     * @param uid
     * @return
     */
    Address findLastModified(Integer uid);
}
