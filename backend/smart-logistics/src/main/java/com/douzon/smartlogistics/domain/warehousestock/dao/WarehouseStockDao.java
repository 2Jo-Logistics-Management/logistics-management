package com.douzon.smartlogistics.domain.warehousestock.dao;

import com.douzon.smartlogistics.domain.warehousestock.dao.mapper.WarehouseStockMapper;
import com.douzon.smartlogistics.domain.warehousestock.dto.WarehouseStockResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
@Slf4j
public class WarehouseStockDao {

    private final WarehouseStockMapper warehouseStockMapper;

    public List<WarehouseStockResponseDto> searchWarehouseStockList(Long warehouseStockNo, Integer warehouseNo, String receiveCode,
        Integer receiveItemNo, Integer itemCode, String itemName, String startDate, String endDate) {

        return warehouseStockMapper.searchWarehouseStockList(warehouseStockNo, warehouseNo, receiveCode,
            receiveItemNo, itemCode, itemName, startDate, endDate);
    }
}
