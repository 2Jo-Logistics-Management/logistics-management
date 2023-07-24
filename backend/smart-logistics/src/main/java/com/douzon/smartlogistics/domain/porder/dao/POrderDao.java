package com.douzon.smartlogistics.domain.porder.dao;

import com.douzon.smartlogistics.domain.entity.POrder;
import com.douzon.smartlogistics.domain.entity.constant.State;
import com.douzon.smartlogistics.domain.porder.dao.mapper.POrderMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
@Slf4j
public class POrderDao {

    private final POrderMapper pOrderMapper;

    public List<POrder> searchPOrder(String pOrderCode, State state, String createId, String createIp,
        Long accountNo, String startDate, String endDate) {

        List<POrder> pOrderList = pOrderMapper.searchPOrder(pOrderCode, createId, createIp, accountNo, state);

        log.info(String.valueOf(pOrderList.size()));

        return pOrderList;
    }
}
