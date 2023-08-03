package com.douzon.smartlogistics.domain.porderitem.dao.mapper;

import com.douzon.smartlogistics.domain.entity.POrderItem;
import com.douzon.smartlogistics.domain.porderitem.dto.POrderItemInsertDto;
import com.douzon.smartlogistics.domain.porderitem.dto.POrderItemModifyDto;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface POrderItemMapper {

    @Transactional
    void insert(@Param("pOrderItem") POrderItemInsertDto pOrderItem);

    @Transactional
    void delete(String retrievePOrderCode);

    @Transactional
    void modify(@Param("pOrderCode") Long pOrderItemNo,
        @Param("pOrderItemModifyDto") POrderItemModifyDto pOrderItemModifyDto);

    Optional<POrderItem> retrieve(@Param("pOrderItemNo") Long pOrderItemNo);

    List<POrderItem> searchPOrderItemList(@Param("pOrderCode") String pOrderCode);

    @Transactional
    void deletePOrderItem(@Param("pOrderItemNo") Long pOrderItemNo);
}
