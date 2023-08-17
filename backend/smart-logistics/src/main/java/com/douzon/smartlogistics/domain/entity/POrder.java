package com.douzon.smartlogistics.domain.entity;

import com.douzon.smartlogistics.domain.entity.constant.State;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class POrder {

    private final String pOrderCode;
    private final String pOrderDate;
    private final String manager;
    private final Integer accountNo;
    private final State state;
    private final String createDate;
    private final String createIp;
    private final String createId;
    private final String modifyDate;
    private final String modifyIp;
    private final String modifyId;
}
