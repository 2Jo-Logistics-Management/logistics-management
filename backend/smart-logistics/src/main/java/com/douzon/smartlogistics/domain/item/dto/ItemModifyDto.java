package com.douzon.smartlogistics.domain.item.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ItemModifyDto {

    private final String itemName;
    private final String spec;
    private final String unit;
    private final String modifyIp;
    private final String modifyId;
}
