package com.douzon.smartlogistics.domain.warehouse.dao.mapper;

import com.douzon.smartlogistics.domain.receiveitem.dto.ReceiveItemDto;
import com.douzon.smartlogistics.domain.warehouse.dto.WarehouseModifyDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WarehouseMapper {
    void insertWarehouse(ReceiveItemDto rvItem);

    void modifyWarehouse(
            @Param("receiveItemNo") Long retrieveReceiveItemNo,
            @Param("receiveItemDto") ReceiveItemDto receiveItemDto
    );
}
