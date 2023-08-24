package com.douzon.smartlogistics.domain.warehouse.dao.mapper;

import com.douzon.smartlogistics.domain.entity.Warehouse;
import com.douzon.smartlogistics.domain.warehouse.dto.WarehouseInsertDto;
import com.douzon.smartlogistics.domain.warehouse.dto.WarehouseModifyDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface WarehouseMapper {

    List<Warehouse> warehouseList(@Param("warehouseNo") Integer warehouseNo,
        @Param("warehouseName") String warehouseName);

    @Transactional
    void modify(@Param("warehouseNo") Integer sectionNo,
        @Param("warehouseModifyDto") WarehouseModifyDto warehouseModifyDto);

    @Transactional
    void delete(@Param("warehouseNo") Integer warehouseNo);

    @Transactional
    void insert(@Param("warehouseInsertDto") WarehouseInsertDto warehouseInsertDto);

    boolean checkExistWarehouse(Integer warehouseNo);
}
