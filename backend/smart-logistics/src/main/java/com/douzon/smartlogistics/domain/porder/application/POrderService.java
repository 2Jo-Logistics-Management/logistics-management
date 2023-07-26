package com.douzon.smartlogistics.domain.porder.application;

import com.douzon.smartlogistics.domain.entity.POrder;
import com.douzon.smartlogistics.domain.entity.constant.State;
import com.douzon.smartlogistics.domain.porder.dao.POrderDao;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class POrderService {

    private final POrderDao pOrderDao;
    public List<POrder> searchPOrder(String pOrderCode, State state, String createId, String createIp, Long accountNo,
        String startDate, String endDate, String pOrderDate) {

        return pOrderDao.searchPOrder(pOrderCode, state, createId, createIp, accountNo, startDate, endDate, pOrderDate);
    }
}
