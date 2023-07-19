package com.douzon.smartlogistics.domain.item.dao.mapper;

import com.douzon.smartlogistics.domain.entity.Item;
import com.douzon.smartlogistics.domain.item.dto.ItemInsertDto;
import com.douzon.smartlogistics.domain.item.dto.ItemModifyDto;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ItemMapper {

    List<Item> searchItemList(
        @Param("itemCode") Long itemCode,
        @Param("itemName") String itemName,
        @Param("createDate") String createDate,
        @Param("createId") String createId);

    int insert(ItemInsertDto itemInsertDto);

    Optional<Item> retrieve(Long itemCode);

    void modify(@Param("itemCode") Long itemCode, @Param("itemModifyDto") ItemModifyDto itemModifyDto);
}
