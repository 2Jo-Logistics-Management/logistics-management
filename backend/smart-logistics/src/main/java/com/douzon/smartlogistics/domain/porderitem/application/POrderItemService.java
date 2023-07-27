package com.douzon.smartlogistics.domain.porderitem.application;

import com.douzon.smartlogistics.domain.porderitem.dao.POrderItemDao;
import com.douzon.smartlogistics.domain.porderitem.dto.POrderItemInsertDto;
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
}
