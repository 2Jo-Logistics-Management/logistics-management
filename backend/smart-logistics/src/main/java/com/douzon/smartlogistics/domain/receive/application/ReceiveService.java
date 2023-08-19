package com.douzon.smartlogistics.domain.receive.application;

import com.douzon.smartlogistics.domain.entity.Receive;
import com.douzon.smartlogistics.domain.receive.dto.CmpPOrderDto;
import com.douzon.smartlogistics.domain.receive.dto.ReceiveListDto;
import com.douzon.smartlogistics.domain.entity.constant.SeqCode;
import com.douzon.smartlogistics.domain.receive.dao.ReceiveDao;
import com.douzon.smartlogistics.domain.receive.dto.ReceiveInsertDto;
import com.douzon.smartlogistics.domain.receive.dto.ReceiveModifyDto;
import com.douzon.smartlogistics.global.common.util.AutoSeqGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReceiveService {
    private final ReceiveDao receiveDao;

    public List<Receive> findReceive(String receiveCode, String manager, String createIp, String createId, String startDate, String endDate) {
        if (startDate != null && !startDate.isEmpty()) {
            startDate += " 00:00:00";
        }

        if (endDate != null && !endDate.isEmpty()) {
            endDate += " 23:59:59";
        }

        return receiveDao.findReceive(receiveCode, manager, createIp, createId, startDate, endDate);
    }

    public List<CmpPOrderDto> waitingReceive(String porderCode, Integer itemCode, String itemName, String manager, Integer accountNo, String accountName, String startDate, String endDate) {
        if (startDate != null && !startDate.isEmpty()) {
            startDate += " 00:00:00";
        }

        if (endDate != null && !endDate.isEmpty()) {
            endDate += " 23:59:59";
        }
        return receiveDao.waitingReceive(porderCode, itemCode, itemName, manager, accountNo, accountName, startDate, endDate);
    }

    @Transactional
    public void insertReceive(ReceiveInsertDto receiveInsertDto){
        receiveInsertDto.setReceiveCode(AutoSeqGenerator.generate(SeqCode.RV));
        receiveDao.insertReceive(receiveInsertDto);

    }

    @Transactional
    public void deleteReceive(String receiveCode) {
        receiveDao.deleteReceive(receiveCode);
    }

    @Transactional
    public void modifyReceive(String receiveCode, ReceiveModifyDto receiveModifyDto) {
        receiveDao.modifyReceive(receiveCode, receiveModifyDto);
    }


}
