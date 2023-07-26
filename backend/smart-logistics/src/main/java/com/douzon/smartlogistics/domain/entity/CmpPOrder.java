package com.douzon.smartlogistics.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CmpPOrder {
    private final Integer porderItemNo;
    private final String porderCode;
    private final String state;
    private final String manager;
    private final Integer itemCode;
    private final String itemName;
    private final Integer porderCount;
    private final Double totalReceiveCount;
    private final String unit;
    private final Integer accountNo;
    private final String accountName;
    private final String createDate;
}
