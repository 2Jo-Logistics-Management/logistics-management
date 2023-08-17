package com.douzon.smartlogistics.domain.porder.dao.mapper;

import com.douzon.smartlogistics.domain.entity.POrder;
import com.douzon.smartlogistics.domain.entity.constant.State;
import com.douzon.smartlogistics.domain.porder.dto.POrderInsertDto;
import com.douzon.smartlogistics.domain.porder.dto.POrderModifyDto;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface POrderMapper {

    List<POrder> searchPOrder(String pOrderCode, String manager, String createId, String createIp, Integer accountNo,
        State state, String startDate, String endDate, String pOrderDate);

    @Transactional
    void insert(POrderInsertDto pOrderInsertDto);

    Optional<POrder> retrieve(String pOrderCode);

    void modify(@Param("pOrderCode") String retrievePOrderCode,
        @Param("pOrderModifyDto") POrderModifyDto pOrderModifyDto);

    void delete(String retrievePOrderCode);
}
