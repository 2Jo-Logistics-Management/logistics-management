package com.douzon.smartlogistics.domain.receiveitem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import reactor.util.annotation.Nullable;

import javax.validation.constraints.*;

@NoArgsConstructor
@Getter
@Setter
public class ReceiveItemDto {
    @Max(30)
    private Long receiveItemNo;

    @Size(max=20)
    private String receiveCode;

    private String porderCode;
    private Long porderItemNo;
    private Integer itemCode;
    private String manager;

    @PositiveOrZero
    @JsonProperty(value = "receiveCount")
    private Double receiveCount;
    private Integer accountNo;

    @Digits(integer = 4, fraction = 0)
    @JsonProperty(value = "warehouseSectionNo")
    private Integer warehouseSectionNo;

    @Nullable
    private String createDate;
    private String createIp;
    private String createId;
    @Nullable
    private String modifyDate;
    private String modifyIp;
    private String modifyId;
}

