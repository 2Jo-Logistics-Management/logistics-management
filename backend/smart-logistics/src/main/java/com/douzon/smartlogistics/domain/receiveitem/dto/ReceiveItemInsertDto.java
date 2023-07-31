package com.douzon.smartlogistics.domain.receiveitem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@NoArgsConstructor
@Getter
@Setter
public class ReceiveItemInsertDto {

    @NotBlank
    @Size(max = 20)
    private String receiveCode;

    @NotBlank
    @Size(max = 20)
    private String porderCode;
    private Integer porderItemNo;

    @NotBlank
    @Digits(integer = 10,fraction = 0)
    private Integer itemCode;

    @NotBlank
    @Size(max = 15)
    private String manager;

    @JsonProperty(value = "receiveCount")
    private Double receiveCount;

    @NotBlank
    @Digits(integer = 10,fraction = 0)
    private Integer accountNo;

    @Digits(integer = 4, fraction = 0)
    @JsonProperty(value = "warehouseSectionNo")
    private Integer warehouseSectionNo;

    private String createIp;
    private String createId;

}
