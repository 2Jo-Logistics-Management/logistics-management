package com.douzon.smartlogistics.domain.porder.dao;

import com.douzon.smartlogistics.domain.entity.POrder;
import com.douzon.smartlogistics.domain.entity.constant.State;
import com.douzon.smartlogistics.domain.porder.dao.mapper.POrderMapper;
import com.douzon.smartlogistics.domain.porder.dto.POrderInsertDto;
import com.douzon.smartlogistics.domain.porder.dto.POrderModifyDto;
import com.douzon.smartlogistics.domain.porder.exception.NotWaitStateException;
import com.douzon.smartlogistics.domain.porderitem.dao.mapper.POrderItemMapper;
import com.douzon.smartlogistics.domain.porderitem.dto.POrderItemInsertDto;
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

    public List<POrder> searchPOrder(String pOrderCode, String manager, State state, String createId, String createIp,
        Integer accountNo, String startDate, String endDate, String pOrderDate) {

        List<POrder> pOrderList = pOrderMapper.searchPOrder(pOrderCode, manager, createId, createIp, accountNo, state,
            startDate, endDate, pOrderDate);

        return pOrderList;
    }

    @Transactional
    public void insert(POrderInsertDto pOrderInsertDto) {
        pOrderMapper.insert(pOrderInsertDto);

        for (POrderItemInsertDto pOrderItem : pOrderInsertDto.getPOrderItems()) {
            pOrderItem.setPOrderCode(pOrderInsertDto.getPOrderCode());

            pOrderItemMapper.insert(pOrderItem);
        }
    }

    @Transactional
    public void modify(String pOrderCode, POrderModifyDto pOrderModifyDto) {
        POrder retrievePOrder = retrievePOrder(pOrderCode);

        pOrderMapper.modify(retrievePOrder.getPOrderCode(), pOrderModifyDto);
    }

    @Transactional
    public void delete(String pOrderCode) {
        POrder retrievePOrder = retrievePOrder(pOrderCode);

        if (retrievePOrder.getState() == State.WAIT) {
            pOrderItemMapper.delete(retrievePOrder.getPOrderCode());
            pOrderMapper.delete(retrievePOrder.getPOrderCode());
            return;
        }

        throw new NotWaitStateException();
    }

    private POrder retrievePOrder(String pOrderCode) {
        return pOrderMapper.retrieve(pOrderCode).orElseThrow(() -> {
            throw new NoSuchElementException("해당 발주 내역은 존재하지 않습니다.");
        });
    }
}
