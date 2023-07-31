package com.douzon.smartlogistics.domain.receiveitem.dao;

import com.douzon.smartlogistics.domain.receiveitem.dao.mapper.ReceiveItemMapper;
import com.douzon.smartlogistics.domain.receiveitem.dto.ReceiveItemInsertDto;
import com.douzon.smartlogistics.domain.receiveitem.dto.ReceiveItemModifyDto;
import com.douzon.smartlogistics.domain.warehouse.dao.mapper.WarehouseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ReceiveItemDao {

    private final ReceiveItemMapper receiveItemMapper;
    private final WarehouseMapper warehouseMapper;

    @Transactional
    public void deleteReceiveItem(Long receiveItemNo) {
        retrieveReceiveItem(receiveItemNo);
        receiveItemMapper.deleteReceiveItem(receiveItemNo);
    }
    @Transactional
    public void modifyReceiveItem(Long receiveItemNo, ReceiveItemModifyDto receiveItemModifyDto) {
        Long retrieveReceiveItemNo = retrieveReceiveItem(receiveItemNo);
        receiveItemMapper.modifyReceiveItem(retrieveReceiveItemNo,receiveItemModifyDto);
        warehouseMapper.modifyWarehouse(retrieveReceiveItemNo, receiveItemModifyDto);
    }
    //TODO: 전역 예외처리 필요
    private Long retrieveReceiveItem(Long receiveItemNo) {
        return receiveItemMapper.retrieveReceiveItem(receiveItemNo).orElseThrow(() -> {
            throw new NoSuchElementException("해당 입고물품은 존재하지 않습니다.");
        }).getReceiveItemNo();
    }
    @Transactional
    public void insertReceiveItem(ReceiveItemInsertDto receiveItemInsertDto) {
        receiveItemMapper.insertReceiveItem(receiveItemInsertDto);
    }
}
