package com.douzon.smartlogistics.domain.warehouse.dao;

import com.douzon.smartlogistics.domain.entity.Warehouse;
import com.douzon.smartlogistics.domain.warehouse.dao.mapper.WarehouseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
@Slf4j
public class WarehouseDao {

    private final WarehouseMapper warehouseMapper;

    public List<Warehouse> searchInventoryList(Integer warehouseSectionNo, Integer receiveItemNo, Integer itemCode) {
        return warehouseMapper.searchInventoryList(warehouseSectionNo,receiveItemNo,itemCode);
    }
}
