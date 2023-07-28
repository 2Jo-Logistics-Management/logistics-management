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
public class POrderItemInsertDto {

    @NotBlank
    @Size(max = 20)
    @JsonProperty(value = "pOrderCode")
    private String pOrderCode;

    @NotBlank
    @Size(max = 15)
    private String manager;

    @NotBlank
    @Digits(integer = 10, fraction = 0)
    private Integer itemCode;

    @NotBlank
    @JsonProperty(value = "pOrderCount")
    private Double pOrderCount;

    @NotBlank
    @JsonProperty(value = "pOrderPrice")
    private Integer pOrderPrice;

    @NotBlank
    @JsonProperty(value = "pOrderItemPrice")
    private Long pOrderItemPrice;

    @NotBlank
    private String receiveDeadline;
    private String createIp;
    private String createId;
}