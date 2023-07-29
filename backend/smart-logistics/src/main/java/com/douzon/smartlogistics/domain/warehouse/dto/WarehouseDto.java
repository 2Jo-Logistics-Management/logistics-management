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
public class WarehouseDto {
    private Integer sectionNo;
    private String receiveCode;
    private Long receiveItemNo;
    private Integer itemCode;
    private Double count;
    @Nullable
    private String registDate;
    private String createDate;
    private String createIp;
    private String createId;
    private String modifyDate;
    private String modifyIp;
    private String modifyId;
}
