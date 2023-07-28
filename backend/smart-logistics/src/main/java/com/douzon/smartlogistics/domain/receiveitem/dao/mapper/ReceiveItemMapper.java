package com.douzon.smartlogistics.domain.receiveitem.dao.mapper;

import com.douzon.smartlogistics.domain.receiveitem.dto.ReceiveItemDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Mapper
public interface ReceiveItemMapper {

    void insertReceiveItem(@Param("receiveItem") ReceiveItemDto receiveItem);

    void deleteReceiveItem(Long receiveItemNo);

//    List<Map<String, Object>> findReceiveItem(String receiveCode);


    Optional<ReceiveItemDto> retrieveReceiveItem(Long receiveItemNo);

//    void insertWarehouse(Map<String, Object> items);

    ReceiveItemDto findReceiveItem(
            @Param("rvCode") String rvCode,
            @Param("poCode") String poCode,
            @Param("itemCode") Integer itemCode,
            @Param("accountNo") Integer accountNo,
            @Param("sectionNo") Integer sectionNo
    );
}
