package com.douzon.smartlogistics.domain.warehouse.dao.mapper;

import com.douzon.smartlogistics.domain.entity.Warehouse;
import com.douzon.smartlogistics.domain.warehouse.dto.WarehouseInsertDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface WarehouseMapper {

    List<Warehouse> warehouseList(@Param("warehouseNo") Integer warehouseNo,
        @Param("warehouseName") String warehouseName);

    void modify(@Param("sectionName") String sectionName,
                @Param("sectionNo") Integer sectionNo);

    void delete(@Param("sectionName") String sectionName);

    @Transactional
    void insert(@Param("warehouseInsertDto") WarehouseInsertDto warehouseInsertDto);
}
