package com.douzon.smartlogistics.domain.receive.dao;

import com.douzon.smartlogistics.domain.entity.Receive;
import com.douzon.smartlogistics.domain.receive.dao.mapper.ReceiveMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReceiveDao {

    private final ReceiveMapper receiveMapper;
    public List<Receive> findReceive(String receiveCode, String manager, int itemCode, String itemName, int accountNo, String accountName, String startDate, String endDate) {
        return receiveMapper.findReceive(receiveCode, manager, itemCode, itemName, accountNo, accountName, startDate, endDate);
    }
}
