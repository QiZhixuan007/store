package com.cy.store.service;

import com.cy.store.entity.District;

import java.util.List;

public interface IDistrictService {

    /**
     * 根据父代号查询区域信息
     * @param parent
     * @return
     */
    List<District> getByParent(String parent);

    /**
     * 根据代号查询区域名称
     * @param code
     * @return
     */
    String getNameByCode(String code);


}
