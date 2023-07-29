package com.douzon.smartlogistics.domain.receive.dao;

import com.douzon.smartlogistics.domain.entity.CmpPOrder;
import com.douzon.smartlogistics.domain.entity.ReceiveList;
import com.douzon.smartlogistics.domain.receive.dao.mapper.ReceiveMapper;
import com.douzon.smartlogistics.domain.receive.dto.ReceiveInsertDto;
import com.douzon.smartlogistics.domain.receiveitem.dao.mapper.ReceiveItemMapper;
import com.douzon.smartlogistics.domain.receiveitem.dto.ReceiveItemDto;
import com.douzon.smartlogistics.domain.warehouse.dao.mapper.WarehouseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ReceiveDao {

    private final ReceiveMapper receiveMapper;
    private final ReceiveItemMapper receiveItemMapper;
    private final WarehouseMapper warehouseMapper;

    public List<ReceiveList> findReceive(String receiveCode, String manager, Integer itemCode, String itemName, Integer accountNo, String accountName, String startDate, String endDate) {
        return receiveMapper.findReceive(receiveCode, manager, itemCode, itemName, accountNo, accountName, startDate, endDate);
    }

    public List<CmpPOrder> waitingReceive(String porderCode, Integer itemCode, String itemName, String manager, Integer accountNo, String accountName, String startDate, String endDate) {
        return receiveMapper.waitingReceive(porderCode, itemCode, itemName, manager, accountNo, accountName, startDate, endDate);
    }

    @Transactional
    public void insertReceive(ReceiveInsertDto receiveInsertDto){
        receiveMapper.insertReceive(receiveInsertDto);

        for(ReceiveItemDto receiveItem : receiveInsertDto.getReceiveItems()) {
            receiveItem.setReceiveCode(receiveInsertDto.getReceiveCode());
            receiveItemMapper.insertReceiveItem(receiveItem);
            // 입고 후 해당 데이터를 불러와서 창고 적재
            String rvCode = receiveItem.getReceiveCode();
            String poCode = receiveItem.getPorderCode();
            Integer itemCode = receiveItem.getItemCode();
            Integer accountNo = receiveItem.getAccountNo();
            Integer sectionNo = receiveItem.getWarehouseSectionNo();
            ReceiveItemDto rvItem = receiveItemMapper.findReceiveItem(rvCode, poCode, itemCode, accountNo, sectionNo);
            warehouseMapper.insertWarehouse(rvItem);
        }
    }

            public void deleteReceive(String receiveCode) {
        retrieveReceive(receiveCode);
        receiveMapper.deleteReceive(receiveCode);
    }

    public void deleteReceiveItem(Long receiveItemNo) {
        retrieveReceiveItem(receiveItemNo);
        receiveMapper.deleteReceiveItem(receiveItemNo);
    }

    //TODO: 전역 예외처리 필요
    private void retrieveReceive(String receiveCode) {
        receiveMapper.retrieve(receiveCode).orElseThrow(() -> {
            throw new NoSuchElementException("해당 입고는 존재하지 않습니다.");
        });
    }

    private void retrieveReceiveItem(Long receiveItemNo) {
        receiveMapper.retrieveReceiveItem(receiveItemNo).orElseThrow(() -> {
            throw new NoSuchElementException("해당 입고물품은 존재하지 않습니다.");
        });
    }
}
