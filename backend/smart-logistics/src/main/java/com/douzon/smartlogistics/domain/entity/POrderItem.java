package com.douzon.smartlogistics.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class POrderItem {

    private final Long pOrderItemNo;
    private final String pOrderCode;
    private final String manager;
    private final Integer itemCode;
    private final Double pOrderCount;
    private final Integer pOrderPrice;
    private final Long pOrderItemPrice;
    private final String receiveDeadline;
    private final String createIp;
    private final String createId;
    private final String modifyDate;
    private final String modifyIp;
    private final String modifyId;
}
