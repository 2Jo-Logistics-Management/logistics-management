package com.douzon.smartlogistics.domain.porder.dao.mapper;

import com.douzon.smartlogistics.domain.entity.POrder;
import com.douzon.smartlogistics.domain.entity.constant.State;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface POrderMapper {

    List<POrder> searchPOrder(String pOrderCode, String createId, String createIp, Long accountNo, State state);
}
