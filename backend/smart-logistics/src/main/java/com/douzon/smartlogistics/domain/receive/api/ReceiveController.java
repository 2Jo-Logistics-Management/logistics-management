package com.douzon.smartlogistics.domain.receive.api;

import com.douzon.smartlogistics.domain.entity.Receive;
import com.douzon.smartlogistics.domain.receive.dto.ReceiveListDto;
import com.douzon.smartlogistics.domain.receive.dto.CmpPOrderDto;
import com.douzon.smartlogistics.domain.receive.application.ReceiveService;
import com.douzon.smartlogistics.domain.receive.dto.ReceiveInsertDto;
import com.douzon.smartlogistics.domain.receive.dto.ReceiveModifyDto;
import com.douzon.smartlogistics.global.common.aop.annotation.TimeOut;
import com.douzon.smartlogistics.global.common.response.CommonResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "입고관리 API 명세서")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/receive")
public class ReceiveController {

    private final ReceiveService receiveService;

    @Operation(summary = "입고 리스트 조회",
            description = "입고 리스트 조회 요청을 처리하고 데이터베이스를 조회해 리스트로 결과를 반환합니다.",
            responses = {@ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CommonResponse.class)
                    ))})
    @TimeOut
    @GetMapping("/list")
    public ResponseEntity<CommonResponse<List<Receive>>> findReceive(
            @RequestParam(required = false, defaultValue = "") @Parameter(description = "입고코드") String receiveCode,
            @RequestParam(required = false, defaultValue = "") @Parameter(description = "담당자") String manager,
            @RequestParam(required = false, defaultValue = "0") @Parameter(description = "상품코드") Integer itemCode,
            @RequestParam(required = false, defaultValue = "") @Parameter(description = "상품명") String itemName,
            @RequestParam(required = false, defaultValue = "0") @Parameter(description = "거래처번호") Integer accountNo,
            @RequestParam(required = false, defaultValue = "") @Parameter(description = "거래처명") String accountName,
            @RequestParam(required = false, defaultValue = "") @Parameter(description = "조회 시작날짜") String startDate,
            @RequestParam(required = false, defaultValue = "") @Parameter(description = "조회 마감날짜") String endDate,
            @RequestParam(required = false, defaultValue = "") @Parameter(description = "작성자 ip") String createIp,
            @RequestParam(required = false, defaultValue = "") @Parameter(description = "작성자 id") String createId,
            @RequestParam(defaultValue = "1") @Parameter(description = "페이지 번호") int pageNum,
            @RequestParam(defaultValue = "50") @Parameter(description = "페이지 크기") int pageSize
    ) {
        log.info("ReceiveControllerListIN");
        PageHelper.startPage(pageNum, pageSize);

        List<Receive> receiveList = receiveService.findReceive(
                receiveCode, manager, createIp, createId, startDate, endDate);
        PageInfo<Receive> pageInfo = new PageInfo<>(receiveList);

        log.info("ReceiveControllerListOUT");
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWith(receiveList));
    }
    @Operation(summary = "입고 등록 전 발주 완료 리스트 조회",
            description = "입고 등록 전 발주 완료 리스트 조회 요청을 처리하고 데이터베이스를 조회해 리스트로 결과를 반환합니다.",
            responses = @ApiResponse(responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CommonResponse.class))))
    @GetMapping("/insert")
    public ResponseEntity<CommonResponse<List<CmpPOrderDto>>> waitingReceive(
            @RequestParam(required = false, defaultValue = "") @Parameter(description = "발주코드") String porderCode,
            @RequestParam(required = false, defaultValue = "0")@Parameter(description = "상품코드")  Integer itemCode,
            @RequestParam(required = false, defaultValue = "") @Parameter(description = "상품명") String itemName,
            @RequestParam(required = false, defaultValue = "") @Parameter(description = "담당자") String manager,
            @RequestParam(required = false, defaultValue = "0")@Parameter(description = "거래처번호")  Integer accountNo,
            @RequestParam(required = false, defaultValue = "") @Parameter(description = "거래처명") String accountName,
            @RequestParam(required = false, defaultValue = "") @Parameter(description = "조회 시작날짜") String startDate,
            @RequestParam(required = false, defaultValue = "") @Parameter(description = "조회 마감날짜") String endDate
    ) {
        List<CmpPOrderDto> cmpPOrderDtoList = receiveService.waitingReceive(
                porderCode, itemCode, itemName, manager, accountNo, accountName, startDate, endDate
        );
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWith(cmpPOrderDtoList));
    }
    @Operation(summary = "입고 등록",
            description = "입고 등록에 알맞은 데이터를 받아 데이터베이스에 삽입합니다.",
            responses = @ApiResponse(responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CommonResponse.class))))
    @PostMapping("/insert")
    public ResponseEntity<CommonResponse<String>> insertReceive(@RequestBody @Valid @Parameter(description = "입고 등록을 위한 데이터") ReceiveInsertDto receiveInsertDto) {
        receiveService.insertReceive(receiveInsertDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWithDefaultMessage());
    }

    @Operation(summary = "입고 삭제",
            description = "입고 삭제에 알맞은 데이터를 받아 데이터베이스의 데이터를 삭제합니다.",
            responses = @ApiResponse(responseCode = "200"))
    @DeleteMapping("/delete")
    public ResponseEntity<CommonResponse<String>> deleteReceive(@RequestParam @Parameter(description = "삭제할 입고의 코드") String receiveCode) {
        receiveService.deleteReceive(receiveCode);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWithDefaultMessage());
    }


    @Operation(summary = "입고 수정",
            description = "입고 수정에 알맞은 데이터를 받아 데이터베이스의 데이터를 수정합니다.",
            responses = @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CommonResponse.class))))
    @PatchMapping("/modify")
    public ResponseEntity<CommonResponse<String>> modifyReceive(
            @RequestParam @Parameter(description = "수정할 입고의 코드") String receiveCode,
            @RequestBody @Valid @Parameter(description = "입고 수정을 위한 데이터") ReceiveModifyDto receiveModifyDto) {

        receiveService.modifyReceive(receiveCode, receiveModifyDto);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWithDefaultMessage());
    }
}
