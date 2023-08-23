package com.douzon.smartlogistics.domain.warehouse.application;

import com.douzon.smartlogistics.domain.entity.Warehouse;
import com.douzon.smartlogistics.domain.warehouse.dao.WarehouseDao;
import com.douzon.smartlogistics.domain.warehouse.dto.WarehouseInsertDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class WarehouseService {

    private final WarehouseDao warehouseSectiondao;

    public List<Warehouse> warehouseSectionList(Integer warehouseNo, String warehouseName) {
        return warehouseSectiondao.warehouseSectionList(warehouseNo, warehouseName);
    }

    public void modify(Integer sectionNo, String sectionName) {
        warehouseSectiondao.modify(sectionNo, sectionName);
    }

    public void delete(String sectionName) {
        warehouseSectiondao.delete(sectionName);
    }

    @Transactional
    public void insert(WarehouseInsertDto warehouseInsertDto) {
        warehouseSectiondao.insert(warehouseInsertDto);
    }
}
