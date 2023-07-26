package com.douzon.smartlogistics.domain.porderitem.dao.mapper;

import com.douzon.smartlogistics.domain.porderitem.dto.POrderItemDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface POrderItemMapper {

    void insert(@Param("pOrderItem") POrderItemDto pOrderItem);

    void delete(String retrievePOrderCode);
}
