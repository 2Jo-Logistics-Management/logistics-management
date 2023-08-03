package com.douzon.smartlogistics.domain.warehouse.dao.mapper;

import com.douzon.smartlogistics.domain.entity.ReceiveItem;
import com.douzon.smartlogistics.domain.entity.Warehouse;
import com.douzon.smartlogistics.domain.receiveitem.dto.ReceiveItemModifyDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface WarehouseMapper {

    @Transactional
    void insertWarehouse(ReceiveItem rvItem);

    @Transactional
    void modifyWarehouse(
            @Param("receiveItemNo") Long retrieveReceiveItemNo,
            @Param("ReceiveItem")ReceiveItemModifyDto receiveItemModifyDto
            );

    List<Warehouse> searchInventoryList(
            @Param("warehouseSectionNo")Integer warehouseSectionNo,
            @Param("receiveItemNo")Integer receiveItemNo,
            @Param("itemCode")Integer itemCode);
}
