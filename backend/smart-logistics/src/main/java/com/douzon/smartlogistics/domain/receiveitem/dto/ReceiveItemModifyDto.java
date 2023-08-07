package com.douzon.smartlogistics.domain.receiveitem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import reactor.util.annotation.Nullable;

import javax.validation.constraints.Digits;

@NoArgsConstructor
@Setter
@Getter
public class ReceiveItemModifyDto {
    @JsonProperty(value = "receiveCount")
    private Double receiveCount;

    @Digits(integer = 4, fraction = 0)
    @JsonProperty(value = "warehouseSectionNo")
    private Integer warehouseSectionNo;

    @Nullable
    private String modifyDate;
    private String modifyIp;
    private String modifyId;


}
