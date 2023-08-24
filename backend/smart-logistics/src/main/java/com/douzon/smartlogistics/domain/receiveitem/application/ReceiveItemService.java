package com.douzon.smartlogistics.domain.receiveitem.application;

import com.douzon.smartlogistics.domain.entity.ReceiveItem;
import com.douzon.smartlogistics.domain.receiveitem.dao.ReceiveItemDao;
import com.douzon.smartlogistics.domain.receiveitem.dto.ReceiveItemDeleteDto;
import com.douzon.smartlogistics.domain.receiveitem.dto.ReceiveItemInsertDto;
import com.douzon.smartlogistics.domain.receiveitem.dto.ReceiveItemModifyDto;
import com.douzon.smartlogistics.domain.warehouse.dao.WarehouseDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReceiveItemService {

    private final ReceiveItemDao receiveItemDao;
    private final WarehouseDao warehouseDao;

    @Transactional
    public void deleteReceiveItem(List<ReceiveItemDeleteDto> receiveItemDeleteDto) {
        for (ReceiveItemDeleteDto item : receiveItemDeleteDto) {
            String receiveCode = item.getReceiveCode();
            Long receiveItemNo = item.getReceiveItemNo();
            receiveItemDao.deleteReceiveItem(receiveCode, receiveItemNo);
            warehouseDao.deleteReceiveItemWarehouse(receiveCode, receiveItemNo);
        }
    }

    @Transactional
    public void modifyReceiveItem(String receiveCode, Long receiveItemNo, ReceiveItemModifyDto receiveItemModifyDto) {
        receiveItemDao.modifyReceiveItem(receiveCode,receiveItemNo,receiveItemModifyDto);
    }

    @Transactional
    public void insertReceiveItem(ReceiveItemInsertDto receiveItemInsertDto) {
        receiveItemDao.insertReceiveItem(receiveItemInsertDto);
    }

    public List<ReceiveItem> searchReceiveItem(String receiveCode) {
        return receiveItemDao.searchReceiveItem(receiveCode);
    }
}
