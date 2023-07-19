package com.douzon.smartlogistics.domain.item.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ItemInsertDto {

    private final String itemName;
    private final String spec;
    private final String unit;
    private final String createIp;
    private final String createId;
}
