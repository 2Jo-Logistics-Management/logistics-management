package com.douzon.smartlogistics.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Getter
@RequiredArgsConstructor
public class Warehouse {

    private final int warehouseNo;
    private final int sectionNo;
    private final int itemCode;
    private final int receiveItemNO;
    private final int count;
    private Date createDate;
    private String createId;
    private String createIp;
    private Date modifyDate;
    private String modifyIp;
    private String modifyId;
}
