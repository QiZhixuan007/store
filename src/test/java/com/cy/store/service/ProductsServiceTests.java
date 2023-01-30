package com.cy.store.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductsServiceTests {

    @Autowired
    IProductService productService;

    @Test
    public void findHotList(){
        System.out.println(productService.findHotList());
    }

    @Test
    public void findById(){

        System.out.println(productService.findBiId(10000002));
    }
}
