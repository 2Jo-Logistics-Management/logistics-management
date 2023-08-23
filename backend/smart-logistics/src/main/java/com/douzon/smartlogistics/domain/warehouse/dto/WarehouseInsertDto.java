package com.douzon.smartlogistics.domain.warehouse.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class WarehouseInsertDto {

    private String warehouseName;
    private String createIp;
    private String createId;
}
