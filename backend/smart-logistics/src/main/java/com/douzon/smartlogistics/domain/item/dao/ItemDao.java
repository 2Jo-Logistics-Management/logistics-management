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
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ItemDao {

    private final ItemMapper itemMapper;

    public List<Item> searchItemList(Long itemCode, String itemName, String createDate, String createId,
        Integer itemPrice) {

        return itemMapper.searchItemList(itemCode, itemName, createDate, createId, itemPrice);
    }

    @Transactional
    public void insert(ItemInsertDto itemInsertDto) {
        itemMapper.insert(itemInsertDto);
    }

    @Transactional
    public void modify(Long itemCode, ItemModifyDto itemModifyDto) {
        Long retrieveItemCode = retrieveItem(itemCode);

        itemMapper.modify(retrieveItemCode, itemModifyDto);
    }


    @Transactional
    public void delete(Long itemCode) {
        Long retrieveItemCode = retrieveItem(itemCode);

        itemMapper.delete(retrieveItemCode);
    }

    private Long retrieveItem(Long itemCode) {
        return itemMapper.retrieve(itemCode).orElseThrow(() -> {
            throw new NoSuchElementException("해당 아이템은 존재하지 않습니다.");
        }).getItemCode();
    }
}
