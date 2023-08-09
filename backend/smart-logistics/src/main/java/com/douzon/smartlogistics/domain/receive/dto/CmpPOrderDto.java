package com.douzon.smartlogistics.domain.receive.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@RequiredArgsConstructor
@Getter
public class CmpPOrderDto {
    @Schema(title = "발주 품목 번호", description = "조회할 발주품목번호 입니다.", example = "9")
    @NotBlank
    private final Integer porderItemNo;

    @Schema(title = "발주 코드", description = "조회할 발주 코드 입니다.", example = "PO20230726145745750")
    @NotBlank
    @Size(max = 20)
    private final String porderCode;

    @Schema(title = "발주 진행상태", description = "조회할 발주 진행상태 입니다.", example = "CMP")
    @NotBlank
    @Size(max = 4)
    private final String state;

    @Schema(title = "담당자", description = "조회할 담당자 입니다.", example = "테스트 담당자")
    @NotBlank
    @Size(max = 15)
    private final String manager;

    @Schema(title = "물품 코드", description = "조회할 물품의 코드입니다.", example = "3")
    @NotBlank
    @Size(max = 15)
    private final Integer itemCode;

    @Schema(title = "물품 이름", description = "조회할 물품의 이름 입니다.", example = "테스트 물품")
    @NotBlank
    @Size(max = 20)
    private final String itemName;

    @Schema(title = "발주 수량", description = "조회할 발주의 수량 입니다.", example = "3.0")
    @NotBlank
    private final Double porderCount;

    @Schema(title = "발주 합계 수량", description = "조회할 발주의 합계 수량 입니다.", example = "8.0")
    @NotBlank
    private final Double totalReceiveCount;

    @Schema(title = "단위", description = "조회할 물품의 단위 입니다.", example = "테스트 단위")
    @NotBlank
    @Size(max = 10)
    private final String unit;

    @Schema(title = "거래처 번호", description = "조회할 거래처 번호입니다.", example = "1005")
    @NotBlank
    @Digits(integer = 10,fraction = 0)
    private final Integer accountNo;

    @Schema(title = "거래처명", description = "조회할 거래처의 이름입니다.", example = "테스트 거래처")
    @NotBlank
    @Size(max = 90)
    private final String accountName;
    private final String createDate;
}
