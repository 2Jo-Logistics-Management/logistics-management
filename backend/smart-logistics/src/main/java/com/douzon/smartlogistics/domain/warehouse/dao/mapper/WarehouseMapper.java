package com.douzon.smartlogistics.domain.warehouse.dao.mapper;

import com.douzon.smartlogistics.domain.receiveitem.dto.ReceiveItemDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WarehouseMapper {
    void insertWarehouse(ReceiveItemDto rvItem);
}
