package com.douzon.smartlogistics.domain.porderitem.application;

import com.douzon.smartlogistics.domain.entity.POrderItem;
import com.douzon.smartlogistics.domain.porderitem.dao.POrderItemDao;
import com.douzon.smartlogistics.domain.porderitem.dto.POrderItemInsertDto;
import com.douzon.smartlogistics.domain.porderitem.dto.POrderItemModifyDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class POrderItemService {

    private final POrderItemDao pOrderItemDao;

    @Transactional
    public void insert(POrderItemInsertDto pOrderItemInsertDto) {
        pOrderItemDao.insert(pOrderItemInsertDto);
    }

    @Transactional
    public void modify(Long pOrderItemNo, POrderItemModifyDto pOrderItemModifyDto) {
        pOrderItemDao.modify(pOrderItemNo, pOrderItemModifyDto);
    }

    public List<POrderItem> searchPOrderItemList(String pOrderCode) {
        return pOrderItemDao.searchPOrderItemList(pOrderCode);
    }
}
