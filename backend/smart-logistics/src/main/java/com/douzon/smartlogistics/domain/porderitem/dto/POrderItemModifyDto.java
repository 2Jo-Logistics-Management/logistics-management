package com.douzon.smartlogistics.domain.porderitem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class POrderItemModifyDto {

    @NotBlank
    @Size(max = 15)
    private String manager;

    @Digits(integer = 10, fraction = 0)
    @JsonProperty(value = "itemCode")
    private Integer itemCode;

    @JsonProperty(value = "pOrderCount")
    private Double pOrderCount;

    @JsonProperty(value = "pOrderPrice")
    private Integer pOrderPrice;

    @JsonProperty(value = "pOrderItemPrice")
    private Long pOrderItemPrice;

    @NotBlank
    private String receiveDeadline;
    private String modifyIp;
    private String modifyId;
}
