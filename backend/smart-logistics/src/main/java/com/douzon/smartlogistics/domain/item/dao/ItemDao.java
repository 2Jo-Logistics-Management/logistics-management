package com.douzon.smartlogistics.domain.item.dao;

import com.douzon.smartlogistics.domain.entity.Item;
import com.douzon.smartlogistics.domain.item.dao.mapper.ItemMapper;
import com.douzon.smartlogistics.domain.item.dto.ItemInsertDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ItemDao {

    private final ItemMapper itemMapper;

    public List<Item> searchItemList(Long itemCode, String itemName, String createDate, String createId) {
        return itemMapper.searchItemList(itemCode, itemName, createDate, createId);
    }

    public void insert(ItemInsertDto itemInsertDto) {
        itemMapper.insert(itemInsertDto);
    }
}
