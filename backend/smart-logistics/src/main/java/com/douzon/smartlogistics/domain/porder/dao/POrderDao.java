package com.douzon.smartlogistics.domain.porder.dao;

import com.douzon.smartlogistics.domain.entity.POrder;
import com.douzon.smartlogistics.domain.entity.constant.State;
import com.douzon.smartlogistics.domain.porder.dao.mapper.POrderMapper;
import com.douzon.smartlogistics.domain.porder.dto.POrderInsertDto;
import com.douzon.smartlogistics.domain.porder.dto.POrderModifyDto;
import com.douzon.smartlogistics.domain.porderitem.dao.mapper.POrderItemMapper;
import com.douzon.smartlogistics.domain.porderitem.dto.POrderItemDto;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Repository
@Slf4j
public class POrderDao {

    private final POrderMapper pOrderMapper;
    private final POrderItemMapper pOrderItemMapper;

    public List<POrder> searchPOrder(String pOrderCode, State state, String createId, String createIp,
        Long accountNo, String startDate, String endDate, String pOrderDate) {

        List<POrder> pOrderList = pOrderMapper.searchPOrder(pOrderCode, createId, createIp, accountNo, state,
            startDate, endDate, pOrderDate);

        return pOrderList;
    }

    @Transactional
    public void insert(POrderInsertDto pOrderInsertDto) {
        pOrderMapper.insert(pOrderInsertDto);

        for (POrderItemDto pOrderItem : pOrderInsertDto.getPOrderItems()) {
            pOrderItem.setPOrderCode(pOrderInsertDto.getPOrderCode());

            pOrderItemMapper.insert(pOrderItem);
        }
    }

    @Transactional
    public void modify(String pOrderCode, POrderModifyDto pOrderModifyDto) {
        String retrievePOrderCode = retrievePOrder(pOrderCode);

        pOrderMapper.modify(retrievePOrderCode, pOrderModifyDto);
    }

    @Transactional
    public void delete(String pOrderCode) {
        String retrievePOrderCode = retrievePOrder(pOrderCode);

        pOrderItemMapper.delete(retrievePOrderCode);
        pOrderMapper.delete(retrievePOrderCode);
    }

    private String retrievePOrder(String pOrderCode) {
        return pOrderMapper.retrieve(pOrderCode).orElseThrow(() -> {
            throw new NoSuchElementException("해당 발주 내역은 존재하지 않습니다.");
        }).getPOrderCode();
    }
}