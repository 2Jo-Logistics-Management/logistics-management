package com.douzon.smartlogistics.domain.warehousesection;

import com.douzon.smartlogistics.domain.entity.Warehouse;
import com.douzon.smartlogistics.domain.entity.WarehouseSection;
import com.douzon.smartlogistics.domain.warehousesection.dao.mapper.WarehouseSectionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class WarehouseSectionDao {

    private final WarehouseSectionMapper warehouseSectionMapper;

    public List<WarehouseSection> warehouseSectionList() {
        return warehouseSectionMapper.warehouseSectionList();
    }

    public List<WarehouseSection> warehouseSectionSearch(String warehouseSectionName){
        return warehouseSectionMapper.searchWarehouseList(warehouseSectionName);
    }


    public void modify(String warehouseSectionModify) {
        warehouseSectionMapper.modify(warehouseSectionModify);
    }

    public void delete(String warehouseSectionName) {
        warehouseSectionMapper.delete(warehouseSectionName);
    }
}
