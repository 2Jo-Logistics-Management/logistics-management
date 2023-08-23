package com.douzon.smartlogistics.domain.receive.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ReceiveModifyDto {
    @Schema(title = "수정 IP" , description = "수정할 발주의 수정 IP 입니다.", example = "발주 수정 테스트 IP")
    private String modifyIp;
    @Schema(title = "수정 ID" , description = "수정할 발주의 수정 ID 입니다.", example = "발주 수정 테스트 ID")
    private String modifyId;

}
