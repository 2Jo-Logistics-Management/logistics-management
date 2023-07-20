package com.douzon.smartlogistics.domain.entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Receive {
    private final String receiveItemNo;
    private final String receiveCode;
    private final String manager;
    private final int itemCode;
    private final String itemName;
    private final int receiveCount;
    private final String unit;
    private final int accountNo;
    private final String accountName;
    private final String createDate;
}
