package com.cy.store.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductMapperTests {

    @Autowired
    ProductMapper productMapper;

    @Test
    public void findHotList(){

        System.out.println(productMapper.findHotList());
    }

    @Test
    public void findById(){
        System.out.println(productMapper.findById(10000001));
    }


}
