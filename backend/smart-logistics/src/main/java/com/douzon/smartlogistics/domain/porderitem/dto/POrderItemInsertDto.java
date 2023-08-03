package com.douzon.smartlogistics.domain.porderitem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(title = "발주 코드", description = "등록할 발주 코드 입니다.", example = "PO20230726145745750")
    @NotBlank
    @Size(max = 20)
    @JsonProperty(value = "pOrderCode")
    private String pOrderCode;

    @Schema(title = "담당자", description = "등록할 담당자 입니다.", example = "테스트 담당자")
    @NotBlank
    @Size(max = 15)
    private String manager;

    @Schema(title = "물품 코드", description = "등록할 물품 코드 입니다.", example = "4")
    @NotBlank
    @Digits(integer = 10, fraction = 0)
    private Integer itemCode;

    @Schema(title = "발주 수량", description = "등록할 발주 수량 입니다.", example = "3.0")
    @NotBlank
    @JsonProperty(value = "pOrderCount")
    private Double pOrderCount;

    @Schema(title = "발주 가격", description = "등록할 발주 가격 입니다.", example = "2000")
    @NotBlank
    @JsonProperty(value = "pOrderPrice")
    private Integer pOrderPrice;

    @Schema(title = "발주 항목 가격", description = "등록할 발주 항목 가격 입니다.", example = "4000")
    @NotBlank
    @JsonProperty(value = "pOrderItemPrice")
    private Long pOrderItemPrice;

    @Schema(title = "수령 마감일", description = "등록할 수령 마감일 입니다.", example = "2023-08-02")
    @NotBlank
    private String receiveDeadline;
    private String createIp;
    private String createId;
}