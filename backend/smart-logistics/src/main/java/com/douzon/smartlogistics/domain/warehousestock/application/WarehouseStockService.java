package com.douzon.smartlogistics.domain.warehousestock.application;

import com.douzon.smartlogistics.domain.warehousestock.dao.WarehouseStockDao;
import com.douzon.smartlogistics.domain.warehousestock.dto.WarehouseStockResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarehouseStockService {

    private final WarehouseStockDao warehouseStockDao;
    public List<WarehouseStockResponseDto> searchWarehouseStockList(Long warehouseStockNo, Integer warehouseNo,
        String receiveCode, Integer receiveItemNo, Integer itemCode, String itemName, String startDate,
        String endDate) {

        return warehouseStockDao.searchWarehouseStockList(warehouseStockNo, warehouseNo, receiveCode, receiveItemNo,
            itemCode, itemName, startDate, endDate);
    }
}
