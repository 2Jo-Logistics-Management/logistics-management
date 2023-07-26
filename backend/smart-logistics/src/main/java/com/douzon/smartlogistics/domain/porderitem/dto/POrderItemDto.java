package com.douzon.smartlogistics.domain.porderitem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class POrderItemDto {

    private String pOrderCode;
    private String manager;
    private Integer itemCode;
    @JsonProperty(value = "pOrderCount")
    private Double pOrderCount;
    @JsonProperty(value = "pOrderPrice")
    private Integer pOrderPrice;
    @JsonProperty(value = "pOrderItemPrice")
    private Long pOrderItemPrice;
    private String receiveDeadline;
    private String createIp;
    private String createId;
}
