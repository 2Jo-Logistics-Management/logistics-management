package com.douzon.smartlogistics.domain.receiveitem.application;

import com.douzon.smartlogistics.domain.receiveitem.dao.ReceiveItemDao;
import com.douzon.smartlogistics.domain.receiveitem.dto.ReceiveItemInsertDto;
import com.douzon.smartlogistics.domain.receiveitem.dto.ReceiveItemModifyDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReceiveItemService {

    private final ReceiveItemDao receiveItemDao;


    @Transactional
    public void deleteReceiveItem(Long receiveItemNo) {
        receiveItemDao.deleteReceiveItem(receiveItemNo);
    }

    @Transactional
    public void modifyReceiveItem(Long receiveItemNo, ReceiveItemModifyDto receiveItemModifyDto) {
        receiveItemDao.modifyReceiveItem(receiveItemNo,receiveItemModifyDto);
    }

    @Transactional
    public void insertReceiveItem(ReceiveItemInsertDto receiveItemInsertDto) {
        receiveItemDao.insertReceiveItem(receiveItemInsertDto);
    }
}
