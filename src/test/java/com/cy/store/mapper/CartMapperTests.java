package com.cy.store.mapper;

import com.cy.store.entity.Cart;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class CartMapperTests {

    @Autowired
    CartMapper cartMapper;

    @Test
    public void insert(){
        Cart cart = new Cart();
        cart.setUid(22);
        cart.setPid(10000001);
        cart.setNum(2);
        cart.setPrice(520);
        cartMapper.insert(cart);
    }

    @Test
    public void updateNumByCid(){
        cartMapper.updateNumByCid(1, 10, "管理员", new Date());
    }

    @Test
    public void findByUidAndCid(){
        Cart cart = cartMapper.findByUidAndCid(22, 1 );
        System.err.println(cart);
    }
}
