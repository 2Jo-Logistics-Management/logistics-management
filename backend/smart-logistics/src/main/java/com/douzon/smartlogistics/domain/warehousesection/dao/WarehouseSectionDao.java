package com.douzon.smartlogistics.domain.warehousesection.dao;

import com.douzon.smartlogistics.domain.entity.WarehouseSection;
import com.douzon.smartlogistics.domain.warehousesection.dao.mapper.WarehouseSectionMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class WarehouseSectionDao {

    private final WarehouseSectionMapper warehouseSectionMapper;
    public List<WarehouseSection> warehouseSectionList(){
           return warehouseSectionMapper.warehouseSectionList();
    }

    public void modify(Integer sectionNo, String sectionName) {
        warehouseSectionMapper.modify(sectionName,sectionNo);
    }

    public void delete(String sectionName) {
        warehouseSectionMapper.delete(sectionName);
    }

    public void insert(String sectionName) {
        warehouseSectionMapper.insert(sectionName);
    }
}
