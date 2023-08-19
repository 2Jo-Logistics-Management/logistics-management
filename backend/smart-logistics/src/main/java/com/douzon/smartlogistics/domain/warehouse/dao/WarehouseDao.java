package com.douzon.smartlogistics.domain.warehouse.dao;

import com.douzon.smartlogistics.domain.entity.Warehouse;
import com.douzon.smartlogistics.domain.warehouse.dao.mapper.WarehouseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Repository
@Slf4j
public class WarehouseDao {

    private final WarehouseMapper warehouseMapper;

    public List<Warehouse> searchInventoryList(Integer warehouseSectionNo, Integer receiveItemNo, Integer itemCode) {
        return warehouseMapper.searchInventoryList(warehouseSectionNo,receiveItemNo,itemCode);
    }

    @Transactional
    public void deleteReceiveWarehouse(String receiveCode){
        warehouseMapper.deleteReceiveWarehouse(receiveCode);
    }

    @Transactional
    public void deleteReceiveItemWarehouse(String receiveCode, Long receiveItemNo){
        warehouseMapper.deleteReceiveItemWarehouse(receiveCode,receiveItemNo);
    }
}
