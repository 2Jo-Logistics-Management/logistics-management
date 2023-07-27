package com.douzon.smartlogistics.domain.porderitem.dao.mapper;

import com.douzon.smartlogistics.domain.porderitem.dto.POrderItemInsertDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface POrderItemMapper {

    void insert(@Param("pOrderItem") POrderItemInsertDto pOrderItem);

    void delete(String retrievePOrderCode);
}
