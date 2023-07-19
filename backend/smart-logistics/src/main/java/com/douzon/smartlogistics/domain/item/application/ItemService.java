package com.douzon.smartlogistics.domain.item.application;

import com.douzon.smartlogistics.domain.entity.Item;
import com.douzon.smartlogistics.domain.item.dao.ItemDao;
import com.douzon.smartlogistics.domain.item.dto.ItemInsertDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemDao itemDao;

    public List<Item> searchItemList(Long itemCode, String itemName, String createDate, String createId) {
        return itemDao.searchItemList(itemCode, itemName, createDate, createId);
    }

    public void insert(ItemInsertDto itemInsertDto) {
        itemDao.insert(itemInsertDto);
    }
}
