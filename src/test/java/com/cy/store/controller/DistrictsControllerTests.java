package com.cy.store.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class DistrictsControllerTests {

    @Autowired
    DistrictController districtController;

    @Test
    public void getByParent(){
        System.out.println(districtController.getByParent("86"));
    }
}
