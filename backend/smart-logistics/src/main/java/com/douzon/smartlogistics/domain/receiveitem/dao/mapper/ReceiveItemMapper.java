package com.douzon.smartlogistics.domain.receiveitem.dao.mapper;

import com.douzon.smartlogistics.domain.receiveitem.dto.ReceiveItemDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReceiveItemMapper {

    void insertReceiveItem(@Param("receiveItem") ReceiveItemDto receiveItem);

    ReceiveItemDto findReceiveItem(String rvCode, String poCode, Integer itemCode, Integer accountNo, Integer sectionNo);

    void modifyReceiveItem(
            @Param("receiveItemNo") Long retrieveReceiveItemNo,
            @Param("receiveItemDto") ReceiveItemDto receiveItemDto
    );
}
