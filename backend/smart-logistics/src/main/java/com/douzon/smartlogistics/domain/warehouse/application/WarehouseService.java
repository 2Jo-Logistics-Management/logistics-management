package com.douzon.smartlogistics.domain.warehouse.application;

import com.douzon.smartlogistics.domain.entity.Warehouse;
import com.douzon.smartlogistics.domain.warehouse.dao.WarehouseDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarehouseService {

    private final WarehouseDao warehouseDao;
    public List<Warehouse> searchInventoryList(Integer warehouseSectionNo, Integer receiveItemNo, Integer itemCode) {
        return warehouseDao.searchInventoryList(warehouseSectionNo,receiveItemNo,itemCode);
    }
}
