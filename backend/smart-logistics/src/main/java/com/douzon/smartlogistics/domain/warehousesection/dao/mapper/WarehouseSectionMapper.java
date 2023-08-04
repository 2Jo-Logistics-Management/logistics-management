package com.douzon.smartlogistics.domain.warehousesection.dao.mapper;

import com.douzon.smartlogistics.domain.entity.WarehouseSection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WarehouseSectionMapper {

    List<WarehouseSection> warehouseSectionList();

    void modify(@Param("sectionName") String sectionName,
                @Param("sectionNo") Integer sectionNo);

    void delete(@Param("sectionName") String sectionName);

    void insert(@Param("sectionName") String sectionName);
}
