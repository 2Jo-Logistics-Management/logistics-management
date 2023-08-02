package com.douzon.smartlogistics.domain.warehousesection.dao.mapper;

import com.douzon.smartlogistics.domain.entity.WarehouseSection;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WarehouseSectionMapper {

    List<WarehouseSection> warehouseSectionList();

    List<WarehouseSection> searchWarehouseList(String warehouseSectionName);

    void modify(String warehouseSectionModify);

    void delete(String warehouseSectionName);
}
