package com.douzon.smartlogistics.domain.warehouse.dao;

import com.douzon.smartlogistics.domain.entity.Warehouse;
import com.douzon.smartlogistics.domain.warehouse.dao.mapper.WarehouseMapper;
import com.douzon.smartlogistics.domain.warehouse.dto.WarehouseInsertDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Slf4j
@RequiredArgsConstructor
public class WarehouseDao {

    private final WarehouseMapper warehouseMapper;
    public List<Warehouse> warehouseSectionList(Integer warehouseNo, String warehouseName){
           return warehouseMapper.warehouseList(warehouseNo, warehouseName);
    }

    public void modify(Integer sectionNo, String sectionName) {
        warehouseMapper.modify(sectionName,sectionNo);
    }

    public void delete(String sectionName) {
        warehouseMapper.delete(sectionName);
    }

    @Transactional
    public void insert(WarehouseInsertDto warehouseInsertDto) {
        warehouseMapper.insert(warehouseInsertDto);
    }
}
