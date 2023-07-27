package com.douzon.smartlogistics.domain.porderitem.dao;

import com.douzon.smartlogistics.domain.entity.Item;
import com.douzon.smartlogistics.domain.entity.POrder;
import com.douzon.smartlogistics.domain.item.dao.mapper.ItemMapper;
import com.douzon.smartlogistics.domain.porder.dao.mapper.POrderMapper;
import com.douzon.smartlogistics.domain.porderitem.dao.mapper.POrderItemMapper;
import com.douzon.smartlogistics.domain.porderitem.dto.POrderItemInsertDto;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Repository
@Slf4j
public class POrderItemDao {

    private final POrderMapper pOrderMapper;
    private final POrderItemMapper pOrderItemMapper;
    private final ItemMapper itemMapper;

    @Transactional
    public void insert(POrderItemInsertDto pOrderItemInsertDto) {
        log.error("여기:{}", pOrderItemInsertDto.getPOrderCode());

        retrievePOrder(pOrderItemInsertDto.getPOrderCode());
        retrieveItem(pOrderItemInsertDto.getItemCode());

        pOrderItemMapper.insert(pOrderItemInsertDto);
    }

    private POrder retrievePOrder(String pOrderCode) {
        return pOrderMapper.retrieve(pOrderCode).orElseThrow(
            () -> {
                throw new NoSuchElementException("해당 발주 데이터는 존재하지 않습니다.");
            }
        );
    }

    private Item retrieveItem(Integer itemCode) {
        return itemMapper.retrieve(itemCode).orElseThrow(
            () -> {
                throw new NoSuchElementException("해당 물품 데이터는 존재하지 않습니다.");
            }
        );
    }
}
