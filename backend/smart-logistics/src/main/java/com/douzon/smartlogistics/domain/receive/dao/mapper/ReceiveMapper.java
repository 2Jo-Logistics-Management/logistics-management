package com.douzon.smartlogistics.domain.receive.dao.mapper;

import com.douzon.smartlogistics.domain.entity.CmpPOrder;
import com.douzon.smartlogistics.domain.entity.Receive;
import com.douzon.smartlogistics.domain.entity.ReceiveItem;
import com.douzon.smartlogistics.domain.entity.ReceiveList;
import com.douzon.smartlogistics.domain.receive.dto.ReceiveInsertDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Mapper
public interface ReceiveMapper {
    List<ReceiveList> findReceive(
            @Param("receiveCode") String receiveCode,
            @Param("manager") String manager,
            @Param("itemCode") Integer itemCode,
            @Param("itemName") String itemName,
            @Param("accountNo") Integer accountNo,
            @Param("accountName") String accountName,
            @Param("startDate") String startDate,
            @Param("endDate") String endDate
    );

    List<CmpPOrder> waitingReceive(
            @Param("porderCode") String porderCode,
            @Param("itemCode") Integer itemCode,
            @Param("itemName") String itemName,
            @Param("manager") String manager,
            @Param("accountNo") Integer accountNo,
            @Param("accountName") String accountName,
            @Param("startDate") String startDate,
            @Param("endDate") String endDate
    );
    @Transactional
    void insertReceive(ReceiveInsertDto receiveInsertDto);

    Optional<ReceiveItem> retrieveReceiveItem(Long receiveItemNo);

    Optional<Receive> retrieve(String receiveCode);

    void deleteReceive(String receiveCode);

    void deleteReceiveItem(Long receiveItemNo);


}
