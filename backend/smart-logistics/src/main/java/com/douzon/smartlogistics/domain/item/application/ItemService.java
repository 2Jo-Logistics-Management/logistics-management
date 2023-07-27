package com.douzon.smartlogistics.domain.item.application;

import com.douzon.smartlogistics.domain.entity.Item;
import com.douzon.smartlogistics.domain.item.dao.ItemDao;
import com.douzon.smartlogistics.domain.item.dto.ItemInsertDto;
import com.douzon.smartlogistics.domain.item.dto.ItemModifyDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemDao itemDao;

    public List<Item> searchItemList(Integer itemCode, String itemName, String createDate, String createId,
        Integer itemPrice) {

        return itemDao.searchItemList(itemCode, itemName, createDate, createId, itemPrice);
    }

    @Transactional
    public void insert(ItemInsertDto itemInsertDto) {
        itemDao.insert(itemInsertDto);
    }

    @Transactional
    public void modify(Integer itemCode, ItemModifyDto itemModifyDto) {
        itemDao.modify(itemCode, itemModifyDto);
    }

    @Transactional
    public void delete(Integer itemCode) {
        itemDao.delete(itemCode);
    }
}
