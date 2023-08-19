package com.douzon.smartlogistics.domain.receiveitem.application;

import com.douzon.smartlogistics.domain.entity.ReceiveItem;
import com.douzon.smartlogistics.domain.receiveitem.dao.ReceiveItemDao;
import com.douzon.smartlogistics.domain.receiveitem.dto.ReceiveItemDeleteDto;
import com.douzon.smartlogistics.domain.receiveitem.dto.ReceiveItemInsertDto;
import com.douzon.smartlogistics.domain.receiveitem.dto.ReceiveItemModifyDto;
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


    @Transactional
    public void deleteReceiveItem(List<ReceiveItemDeleteDto> receiveItemDeleteDto) {
        for (ReceiveItemDeleteDto item : receiveItemDeleteDto) {
//            System.out.println("receiveCode: " + item.getReceiveCode());
//            System.out.println("receiveItemNo: " + item.getReceiveItemNo());
            String receiveCode = item.getReceiveCode();
            Long receiveItemNo = item.getReceiveItemNo();
            System.out.println("receiveCode = " + receiveCode);
            System.out.println("receiveItemNo = " + receiveItemNo);

            receiveItemDao.deleteReceiveItem(receiveCode, receiveItemNo);
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
