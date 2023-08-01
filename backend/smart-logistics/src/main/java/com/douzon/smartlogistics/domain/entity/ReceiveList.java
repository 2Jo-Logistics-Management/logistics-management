package com.douzon.smartlogistics.domain.entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ReceiveList {
    private final String receiveItemNo;
    private final String receiveCode;
    private final String manager;
    private final Long itemCode;
    private final String itemName;
    private final Double receiveCount;
    private final String unit;
    private final Long accountNo;
    private final String accountName;
    private final String createDate;
}
