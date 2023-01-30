package com.cy.store.mapper;

import com.cy.store.entity.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface CartMapper {
    Integer insert(Cart cart);

    Integer updateNumByCid(@Param("cid") Integer cid,
                           @Param("num") Integer num,
                           @Param("modifiedUser") String modifiedUser,
                           @Param("modifiedTime") Date modifiedTime);

    Cart findByUidAndCid(@Param("uid") Integer uid,
                         @Param("cid") Integer cid);
}
