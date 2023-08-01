package com.douzon.smartlogistics.domain.entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ReceiveItem {
    private final Long receiveItemNo;
    private final String receiveCode;
    private final String porderCode;
    private final Long porderItemNo;
    private final Integer itemCode;
    private final String manager;
    private final Double receiveCount;
    private final Integer accountNo;
    private final Integer warehouseSectionNo;
    private final String createDate;
    private final String createIp;
    private final String createId;
    private final String modifyDate;
    private final String modifyIp;
    private final String modifyId;
}