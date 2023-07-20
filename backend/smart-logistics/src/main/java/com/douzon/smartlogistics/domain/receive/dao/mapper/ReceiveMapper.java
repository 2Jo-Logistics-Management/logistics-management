package com.douzon.smartlogistics.domain.receive.dao.mapper;

import com.douzon.smartlogistics.domain.entity.Receive;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReceiveMapper {
    List<Receive> findReceive(
            @Param("receiveCode") String receiveCode,
            @Param("manager") String manager,
            @Param("itemCode") int itemCode,
            @Param("itemName") String itemName,
            @Param("accountNo") int accountNo,
            @Param("accountName") String accountName,
            @Param("startDate") String startDate,
            @Param("endDate") String endDate
    );
}
