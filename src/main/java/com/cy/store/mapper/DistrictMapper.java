package com.cy.store.mapper;

import com.cy.store.entity.District;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DistrictMapper {

    /**
     *
     * 根据父代号查询区域信息
     * @param parent
     * @return
     */
    List<District> findByParent(@Param("parent") String parent);

    /**
     * 根据代号查找地区名
     * @param code
     * @return
     */
    String findNameByCode(@Param("code") String code);
}
