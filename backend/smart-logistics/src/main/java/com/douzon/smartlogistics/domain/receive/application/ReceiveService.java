package com.douzon.smartlogistics.domain.receive.application;

import com.douzon.smartlogistics.domain.entity.Receive;
import com.douzon.smartlogistics.domain.receive.dao.ReceiveDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ReceiveService {
    private final ReceiveDao receiveDao;

    public List<Receive> findReceive(String receiveCode, String manager, int itemCode, String itemName, int accountNo, String accountName, String startDate, String endDate) {
        if (startDate != null && !startDate.isEmpty()) {
            startDate += " 00:00:00";
        }

        if (endDate != null && !endDate.isEmpty()) {
            endDate += " 23:59:59";
        }

        return receiveDao.findReceive(receiveCode, manager, itemCode, itemName, accountNo, accountName, startDate, endDate);
    }
}
