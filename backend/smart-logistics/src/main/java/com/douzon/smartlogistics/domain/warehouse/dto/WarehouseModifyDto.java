package com.douzon.smartlogistics.domain.warehouse.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import reactor.util.annotation.Nullable;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class WarehouseModifyDto {
    private Integer sectionNo;
    private Long receiveItemNo;
    private Double count;
    @Nullable
    private String registDate;
    @Nullable
    private String modifyDate;
    private String modifyIp;
    private String modifyId;
}
