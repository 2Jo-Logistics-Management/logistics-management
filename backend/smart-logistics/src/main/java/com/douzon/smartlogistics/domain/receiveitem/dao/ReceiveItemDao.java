package com.douzon.smartlogistics.domain.receiveitem.dao;
import com.douzon.smartlogistics.domain.receiveitem.dao.mapper.ReceiveItemMapper;
import com.douzon.smartlogistics.domain.receiveitem.dto.ReceiveItemInsertDto;
import com.douzon.smartlogistics.domain.receiveitem.dto.ReceiveItemListDto;
import com.douzon.smartlogistics.domain.receiveitem.dto.ReceiveItemModifyDto;
import com.douzon.smartlogistics.domain.warehousestock.dao.mapper.WarehouseStockMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ReceiveItemDao {

    private final ReceiveItemMapper receiveItemMapper;
    private final WarehouseStockMapper warehouseStockMapper;


    public List<ReceiveItemListDto> searchReceiveItem(String receiveCode) {
        return receiveItemMapper.searchReceiveItem(receiveCode);
    }

    @Transactional
    public void modifyReceiveItem(ReceiveItemModifyDto receiveItemModifyDto) {
        receiveItemMapper.modifyReceiveItem(receiveItemModifyDto);
        warehouseStockMapper.modifyWarehouseStock(receiveItemModifyDto);
    }
    public void deleteReceiveItem(String receiveCode, Long receiveItemNo) {
        retrieveReceiveItem(receiveCode, receiveItemNo);
        receiveItemMapper.deleteReceiveItem(receiveCode, receiveItemNo);
    }

    private Long retrieveReceiveItem(String receiveCode, Long receiveItemNo) {
        return receiveItemMapper.retrieveReceiveItem(receiveCode, receiveItemNo).orElseThrow(() -> {
            throw new NoSuchElementException("해당 입고물품은 존재하지 않습니다.");
        }).getReceiveItemNo();
    }

    @Transactional
    public void insertReceiveItem(ReceiveItemInsertDto receiveItemInsertDto) {
        receiveItemMapper.insertReceiveItem(receiveItemInsertDto);
    }
}
