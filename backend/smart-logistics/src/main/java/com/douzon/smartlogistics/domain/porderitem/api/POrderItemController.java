package com.douzon.smartlogistics.domain.porderitem.api;

import com.douzon.smartlogistics.domain.entity.POrderItem;
import com.douzon.smartlogistics.domain.porderitem.application.POrderItemService;
import com.douzon.smartlogistics.domain.porderitem.dto.POrderItemInsertDto;
import com.douzon.smartlogistics.domain.porderitem.dto.POrderItemModifyDto;
import com.douzon.smartlogistics.global.common.response.CommonResponse;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "발주상품 관리 API 명세서")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/porder-item")
public class POrderItemController {

    private final POrderItemService pOrderItemService;

    @Operation(summary = "발주상품 등록",
               description = "발주상품 등록에 알맞은 데이터를 받아 데이터베이스에 삽입합니다.",
               responses = @ApiResponse(responseCode = "201",
                                        content = @Content(mediaType = "application/json",
                                                           schema = @Schema(implementation = CommonResponse.class))))
    @PostMapping("/insert")
    public ResponseEntity<CommonResponse<String>> insert(@RequestBody @Valid @Parameter(description = "발주품목 등록을 위한 "
        + "데이터") POrderItemInsertDto pOrderItemInsertDto) {

        pOrderItemService.insert(pOrderItemInsertDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(CommonResponse.successWithDefaultMessage());
    }

    @Operation(summary = "발주상품 수정",
               description = "발주상품 수정에 알맞은 데이터를 받아 데이터베이스를 수정합니다.",
               responses = @ApiResponse(responseCode = "200",
                                        content = @Content(mediaType = "application/json",
                                                           schema = @Schema(implementation = CommonResponse.class))))
    @PatchMapping("/modify")
    public ResponseEntity<CommonResponse<String>> modify(
        @RequestParam @Parameter(description = "발주물품 번호") Long pOrderItemNo,
        @RequestBody @Valid @Parameter (description = "발주물품 수정을 위한 데이터") POrderItemModifyDto pOrderItemModifyDto) {

        pOrderItemService.modify(pOrderItemNo, pOrderItemModifyDto);

        return ResponseEntity.status(HttpStatus.OK)
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(CommonResponse.successWithDefaultMessage());
    }

    @Operation(summary = "발주상품 리스트 조회",
               description = "발주상품 리스트 조회 요청을 처리하고 데이터베이스를 조회해",
               responses = {@ApiResponse(responseCode = "200",
                                         content = @Content(mediaType = "application/json", schema = @Schema(implementation = CommonResponse.class)
                                         ))})
    @GetMapping("/list")
    public ResponseEntity<CommonResponse<List<POrderItem>>> searchPOrderItemList(@RequestParam @Parameter(description = "발주코드") String pOrderCode) {

        List<POrderItem> pOrderItems = pOrderItemService.searchPOrderItemList(pOrderCode);

        return ResponseEntity.status(HttpStatus.OK)
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(CommonResponse.successWith(pOrderItems));
    }

    @Operation(summary = "발주상품 삭제",
               description = "발주상품 삭제에 알맞은 데이터를 받아 데이터베이스의 데이터를 삭제합니다.",
               responses = @ApiResponse(responseCode = "200"))
    @DeleteMapping("/delete")
    public ResponseEntity<CommonResponse<String>> delete(@RequestParam @Parameter(description = "발주상품번호") Long pOrderItemNo) {
        pOrderItemService.delete(pOrderItemNo);

        return ResponseEntity.status(HttpStatus.OK)
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(CommonResponse.successWithDefaultMessage());
    }
}