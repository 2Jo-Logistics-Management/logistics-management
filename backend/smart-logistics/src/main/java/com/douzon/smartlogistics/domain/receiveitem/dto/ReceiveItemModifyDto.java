package com.douzon.smartlogistics.domain.receiveitem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import reactor.util.annotation.Nullable;

import javax.validation.constraints.Digits;

@NoArgsConstructor
@Setter
@Getter
public class ReceiveItemModifyDto {
    @Schema(title = "입품목수량", description = "수정할 입고물품의 입고품목수량 입니다.", example = "1.5")
    @JsonProperty(value = "receiveCount")
    private Double receiveCount;

    @Schema(title = "창고분류번호", description = "수정할 창고분류의 창고분류번호 입니다.", example = "8")
    @Digits(integer = 4, fraction = 0)
    @JsonProperty(value = "warehouseSectionNo")
    private Integer warehouseSectionNo;

    @Nullable
    private String modifyDate;
    private String modifyIp;
    private String modifyId;


}
