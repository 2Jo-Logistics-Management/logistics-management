package com.douzon.smartlogistics.domain.receive.dao;

import com.douzon.smartlogistics.domain.entity.Receive;
import com.douzon.smartlogistics.domain.receive.dto.CmpPOrderDto;
import com.douzon.smartlogistics.domain.entity.ReceiveItem;
import com.douzon.smartlogistics.domain.receive.dao.mapper.ReceiveMapper;
import com.douzon.smartlogistics.domain.receive.dto.ReceiveInsertDto;
import com.douzon.smartlogistics.domain.receive.dto.ReceiveModifyDto;
import com.douzon.smartlogistics.domain.receiveitem.dao.mapper.ReceiveItemMapper;
import com.douzon.smartlogistics.domain.receiveitem.dto.ReceiveItemInsertDto;
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

    public List<Receive> findReceive(String receiveCode, String manager, String createIp, String createId, String startDate, String endDate) {
        return receiveMapper.findReceive(receiveCode, manager, createIp, createId, startDate, endDate);
    }
    public List<CmpPOrderDto> waitingReceive(String porderCode, Integer itemCode, String itemName, String manager, Integer accountNo, String accountName, String startDate, String endDate) {
        return receiveMapper.waitingReceive(porderCode, itemCode, itemName, manager, accountNo, accountName, startDate, endDate);
    }

    @Transactional
    public void insertReceive(ReceiveInsertDto receiveInsertDto){
        receiveMapper.insertReceive(receiveInsertDto);

        for(ReceiveItemInsertDto receiveItem : receiveInsertDto.getReceiveItems()) {
            receiveItem.setReceiveCode(receiveInsertDto.getReceiveCode());
            receiveItemMapper.insertReceiveItem(receiveItem);

            // 입고 후 해당 데이터를 불러와서 창고 적재
            ReceiveItem rvItem = receiveItemMapper.findReceiveItem(
                    receiveItem.getReceiveCode(),
                    receiveItem.getPorderCode(),
                    receiveItem.getItemCode(),
                    receiveItem.getAccountNo(),
                    receiveItem.getWarehouseSectionNo()
            );
            warehouseMapper.insertWarehouse(rvItem);
        }
    }

    @Transactional
    public void deleteReceive(String receiveCode) {
        retrieveReceive(receiveCode);
        receiveMapper.deleteReceive(receiveCode);
    }

    //TODO: 전역 예외처리 필요
    private String retrieveReceive(String receiveCode) {
        return receiveMapper.retrieve(receiveCode).orElseThrow(() -> {
            throw new NoSuchElementException("해당 입고는 존재하지 않습니다.");
        }).getReceiveCode();
    }

    @Transactional
    public void modifyReceive(String receiveCode, ReceiveModifyDto receiveModifyDto) {
        String retrieveReceiveCode= retrieveReceive(receiveCode);
        receiveMapper.modifyReceive(retrieveReceiveCode, receiveModifyDto);
    }

}
