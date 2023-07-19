package com.douzon.smartlogistics.domain.item.dao;

import com.douzon.smartlogistics.domain.entity.Item;
import com.douzon.smartlogistics.domain.item.dao.mapper.ItemMapper;
import com.douzon.smartlogistics.domain.item.dto.ItemInsertDto;
import com.douzon.smartlogistics.domain.item.dto.ItemModifyDto;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ItemDao {

    private final ItemMapper itemMapper;

    public List<Item> searchItemList(Long itemCode, String itemName, String createDate, String createId) {
        return itemMapper.searchItemList(itemCode, itemName, createDate, createId);
    }

    public void insert(ItemInsertDto itemInsertDto) {
        itemMapper.insert(itemInsertDto);
    }

    public void modify(Long itemCode, ItemModifyDto itemModifyDto) {
        retrieveItem(itemCode);

        itemMapper.modify(itemCode, itemModifyDto);
    }

    //TODO: 전역 예외처리 필요
    private void retrieveItem(Long itemCode) {
        itemMapper.retrieve(itemCode).orElseThrow(() -> {
            throw new NoSuchElementException("해당 아이템은 존재하지 않습니다.");
        });
    }
}
