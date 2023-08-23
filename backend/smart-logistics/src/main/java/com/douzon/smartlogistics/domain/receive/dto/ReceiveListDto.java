package com.douzon.smartlogistics.domain.receive.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import reactor.util.annotation.Nullable;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@RequiredArgsConstructor
@Getter
@ToString
public class ReceiveListDto {

    @Schema(title = "입고품목번호", description = "조회할 입고 품목번호입니다.")
    @NotBlank
    private String receiveItemNo;

    @Schema(title = "입고 코드", description = "조회할 입고 코드 입니다.")
    @Nullable
    private String receiveCode;

    @Schema(title = "담당자", description = "조회할 담당자 입니다.", example = "테스트 담당자")
    @NotBlank
    @Size(max = 15)
    private String manager;

    @Schema(title = "물품 코드", description = "조회할 물품의 코드입니다.", example = "3")
    @NotBlank
    @Size(max = 15)
    private Long itemCode;

    @Schema(title = "물품 코드", description = "조회할 물품의 코드입니다.", example = "3")
    @NotBlank
    @Size(max = 15)
    private String itemName;

    @Schema(title = "입고 수량", description = "조회할 입고의 수량 입니다.", example = "3.0")
    @NotBlank
    private Double receiveCount;

    @Schema(title = "단위", description = "조회할 물품의 단위 입니다.", example = "테스트 단위")
    @NotBlank
    @Size(max = 10)
    private String unit;

    @Schema(title = "거래처 번호", description = "조회할 거래처 번호입니다.", example = "1005")
    @NotBlank
    @Digits(integer = 10,fraction = 0)
    private Long accountNo;

    @Schema(title = "거래처명", description = "조회할 거래처의 이름입니다.", example = "테스트 거래처")
    @NotBlank
    @Size(max = 90)
    private String accountName;
    private String createDate;
}
