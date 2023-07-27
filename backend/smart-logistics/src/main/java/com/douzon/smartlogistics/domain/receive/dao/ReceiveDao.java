package com.douzon.smartlogistics.domain.receive.dao;

import com.douzon.smartlogistics.domain.entity.CmpPOrder;
import com.douzon.smartlogistics.domain.entity.ReceiveList;
import com.douzon.smartlogistics.domain.receive.dao.mapper.ReceiveMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ReceiveDao {

    private final ReceiveMapper receiveMapper;
    public List<ReceiveList> findReceive(String receiveCode, String manager, Integer itemCode, String itemName, Integer accountNo, String accountName, String startDate, String endDate) {
        return receiveMapper.findReceive(receiveCode, manager, itemCode, itemName, accountNo, accountName, startDate, endDate);
    }

    public List<CmpPOrder> waitingReceive(String porderCode, Integer itemCode, String itemName, String manager, Integer accountNo, String accountName, String startDate, String endDate) {
        return receiveMapper.waitingReceive(porderCode, itemCode, itemName, manager, accountNo, accountName, startDate, endDate);
    }

    public void insertReceive(Map<String, Object> map) {
        Map<String, Object> receive = new HashMap<>();

        //receive_code 생성
        SimpleDateFormat milliDate = new SimpleDateFormat("yyyy.MM.dd hh.mm.ss.SSS");
        String receiveCode = "RV" + milliDate.format(new Date()).replaceAll("[. ]", "");

        //receive, receiveItem 분리
        //receive
        receive.put("receiveCode",receiveCode);
        receive.put("createIp",map.get("createIp"));
        receive.put("createId",map.get("createId"));

        //receiveItem
        List<Map<String, Object>> receiveItem = (List<Map<String, Object>>) map.get("receiveList");
        for (Map<String, Object> item : receiveItem) {
            item.put("receiveCode", receiveCode);
            item.put("createIp",map.get("createIp"));
            item.put("createId",map.get("createId"));
        }
        System.out.println("receive = " + receive);
        System.out.println("receiveItem = " + receiveItem);
        receiveMapper.insertReceive(receive);
        receiveMapper.insertReceiveItem(receiveItem);
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
