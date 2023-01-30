package com.cy.store.service;

import com.cy.store.entity.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AddressServiceTests {

    @Autowired
    private IAddressService addressService;

    @Test
    public void addNewAddress(){
        Address address = new Address();
        address.setPhone("213456789");
        for(int i = 1; i < 21; i++){
            address.setName("女朋友" + i);
            addressService.addNewAddress(3, "女朋友",address);
        }

    }

    @Test
    public void findByUid(){
        List<Address> list = addressService.getByUid(13);
        System.out.println(list);
    }

    @Test
    public void setDefault(){

        addressService.setDefault(29,3,"管理员");
    }

    @Test
    public void delete(){

        addressService.delete(23, 1, "管理员");
    }

    @Test
    public void test001(){
        String test = "0,25.0,37.5,45.0,55.0";
        System.out.println("test:" + test);
        String[] test01 = test.split(",");
        double[] doubles = new double[test01.length];
        for(int i = 0; i < doubles.length; i ++){
            System.out.println("test01:" +
                    "" + i +test01[i]);
        }
        for(int i = 0; i < test01.length; i ++){
            doubles[i] = Double.parseDouble(test01[i]);

        }
        for(int i = 0; i < doubles.length; i ++){
            System.out.println("doubles:" + i +doubles[i]);
        }

    }

}
