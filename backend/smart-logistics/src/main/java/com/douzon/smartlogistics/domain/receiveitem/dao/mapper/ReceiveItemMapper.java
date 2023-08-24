package com.douzon.smartlogistics.domain.receiveitem.dao.mapper;

import com.douzon.smartlogistics.domain.entity.ReceiveItem;
import com.douzon.smartlogistics.domain.receiveitem.dto.ReceiveItemInsertDto;
import com.douzon.smartlogistics.domain.receiveitem.dto.ReceiveItemModifyDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ReceiveItemMapper {

    @Transactional
    void insertReceiveItem(@Param("receiveItem") ReceiveItemInsertDto receiveItem);

    Optional<ReceiveItem> retrieveReceiveItem(String receiveCode, Long receiveItemNo);

    ReceiveItem findReceiveItem(String rvCode, String poCode, Integer itemCode, Integer accountNo, Integer sectionNo);

    @Transactional
    void deleteReceiveItem(String receiveCode, Long receiveItemNo);

    @Transactional
    void modifyReceiveItem(
            @Param("receiveItemNo") Long retrieveReceiveItemNo,
            @Param("ReceiveItem")ReceiveItemModifyDto receiveItemModifyDto
            );

    List<ReceiveItem> searchReceiveItem(
            @Param("receiveCode") String receiveCode);
}
