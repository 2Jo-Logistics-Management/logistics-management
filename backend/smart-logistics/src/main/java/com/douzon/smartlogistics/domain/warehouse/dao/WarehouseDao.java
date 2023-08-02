package com.douzon.smartlogistics.domain.warehouse.dao;


import com.douzon.smartlogistics.domain.entity.Warehouse;
import com.douzon.smartlogistics.domain.warehouse.dao.mapper.WarehouseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class WarehouseDao {

    private final WarehouseMapper warehouseMapper;

    public List<Warehouse> searchWarehouseList(int warehouseSectionNO, int receiveItemNo, String itemCode) {
        return warehouseMapper.searchWarehouseList(warehouseSectionNO, receiveItemNo, itemCode);
    }
}
