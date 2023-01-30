package com.cy.store.service;

import com.cy.store.entity.District;
import com.cy.store.service.impl.DistrictService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DistrictServiceTests {

    @Autowired
    private DistrictService districtService;

    @Test
    public void getByParent(){
        List<District> list = districtService.getByParent("86");
        for(District d : list){
            System.out.println(d);
        }
    }

    @Test
    public void getNameByCode(){
        String name = districtService.getNameByCode("610000");
        System.out.println(name);
    }
}
