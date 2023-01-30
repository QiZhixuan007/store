package com.cy.store.mapper;

import com.cy.store.entity.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AddressMapperTests {

    @Autowired
    private AddressMapper addressMapper;


    @Test
    public void insert(){
        Address address = new Address();
        address.setUid(2);
        address.setPhone("213456789");
        address.setName("女朋友");
        Integer rows = addressMapper.insert(address);
        System.out.println(rows);
    }

    @Test
    public void countByUid(){
        Integer count = addressMapper.countByUid(2);
        System.out.println(count);
    }

    @Test
    public void findByUid(){
        List<Address> list = addressMapper.findByUid(13);
        for(Address i : list){
            System.out.println(i.getProvinceName() + i.getCityName() + i.getAreaName() + i.getAddress());
        }
    }


    @Test
    public void findByAid(){

        System.out.println(addressMapper.findByAid(2));
    }

    @Test
    public void updateNonDefault(){

        System.out.println(addressMapper.updateNonDefault(2));
    }

    @Test
    public void deleteByAid(){
        System.out.println(addressMapper.deleteByAid(1));
    }

    @Test
    public void updateDefaultByAid(){

        System.out.println(addressMapper.findLastModified(3));
    }

}
