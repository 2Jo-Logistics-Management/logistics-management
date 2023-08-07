package com.douzon.smartlogistics.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@Getter
public class Warehouse {

    public final Integer warehouseNo;
    public final Integer sectionNo;
    public final String receiveCode;
    public final String receiveItemCode;
    public final String itemCode;
    public final double count;
    public final Date registDate;
    public final Date createDate;
    public final String createId;
    public final String createIp;
    public final Date modifyDate;
    public final String modifyIp;
    public final String modifyId;

}
