package com.douzon.smartlogistics.domain.warehousesection.application;

import com.douzon.smartlogistics.domain.entity.WarehouseSection;
import com.douzon.smartlogistics.domain.warehousesection.dao.WarehouseSectionDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WarehouseSectionService {

    private final WarehouseSectionDao warehouseSectiondao;

    public List<WarehouseSection> warehouseSectionList(){
        return warehouseSectiondao.warehouseSectionList();
    }

    public void modify(Integer sectionNo, String sectionName) {
         warehouseSectiondao.modify(sectionNo, sectionName);
    }

    public void delete(String sectionName) {
        warehouseSectiondao.delete(sectionName);
    }

    public void insert(String sectionName) {
        warehouseSectiondao.insert(sectionName);
    }
}
