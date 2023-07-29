package com.douzon.smartlogistics.domain.receiveitem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ReceiveItemDto {
    private Long receiveItemNo;
    private String receiveCode;
    private String porderCode;
    private Long porderItemNo;
    private Integer itemCode;
    private String manager;
    @JsonProperty(value = "receiveCount")
    private Double receiveCount;
    private Integer accountNo;
    @JsonProperty(value = "warehouseSectionNo")
    private Integer warehouseSectionNo;
    private String createDate;
    private String createIp;
    private String createId;
    private String modifyDate;
    private String modifyIp;
    private String modifyId;
}
