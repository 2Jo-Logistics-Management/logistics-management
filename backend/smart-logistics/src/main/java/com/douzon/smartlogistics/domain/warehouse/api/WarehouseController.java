package com.douzon.smartlogistics.domain.warehouse.api;

import com.douzon.smartlogistics.domain.entity.Warehouse;
import com.douzon.smartlogistics.domain.warehouse.application.WarehouseService;
import com.douzon.smartlogistics.global.common.response.CommonResponse;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Api(tags = "창고(재고)조회 api 명세서")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/warehouse")
public class WarehouseController {

    private final WarehouseService warehouseService;

    @Operation(summary = "재고 리스트 조회",
            description = "재고 리스트 조회 요청을 처리하고 데이터 베이스를 조회해 리스트로 결과를 반환합니다.",
            responses = {@ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json", schema =
                    @Schema(implementation = CommonResponse.class)))})

    @GetMapping("/list")
    public ResponseEntity<CommonResponse<List<Warehouse>>> searchInventoryList(
            @RequestParam(required = false, defaultValue = "") @Parameter(description = "창고구역번호") Integer warehouseSectionNo,
            @RequestParam(required = false, defaultValue = "") @Parameter(description = "입고물품번호") Integer receiveItemNo,
            @RequestParam(required = false, defaultValue = "") @Parameter(description = "물품번호") Integer itemCode
    ) {

        List<Warehouse> warehouseList = warehouseService.searchInventoryList(warehouseSectionNo,receiveItemNo,itemCode);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWith(warehouseList));
    }
}

