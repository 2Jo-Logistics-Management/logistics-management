package com.douzon.smartlogistics.domain.warehousesection.application;

import com.douzon.smartlogistics.domain.entity.Warehouse;
import com.douzon.smartlogistics.domain.entity.WarehouseSection;
import com.douzon.smartlogistics.domain.warehouse.dao.WarehouseDao;
import com.douzon.smartlogistics.domain.warehousesection.WarehouseSectionDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarehouseSectionService {

    private final WarehouseSectionDao warehouseSectionDao;

    public List<WarehouseSection> warehouseSectionList(){
        return warehouseSectionDao.warehouseSectionList();
    }

    public List<WarehouseSection> warehouseSectionSearch(String warehouseSectionName){
        return warehouseSectionDao.warehouseSectionSearch(warehouseSectionName);
    }

    public void modify(String warehouseSectionName) {
        warehouseSectionDao.modify(warehouseSectionName);
    }

    public void delete(String warehouseSectionName) {
        warehouseSectionDao.delete(warehouseSectionName);
    }
}
