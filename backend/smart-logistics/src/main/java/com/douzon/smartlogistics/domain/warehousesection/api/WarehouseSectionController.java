package com.douzon.smartlogistics.domain.warehousesection.api;



import com.douzon.smartlogistics.domain.entity.WarehouseSection;
import com.douzon.smartlogistics.domain.warehousesection.application.WarehouseSectionService;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "창고구역 api 명세서")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/warehouseSection")
public class WarehouseSectionController {

    private final WarehouseSectionService warehouseSectionService;

    @Operation(summary = "창고명 조회",
            description = "창고구역 조회 요청을 처리하고 데이터 베이스를 조회해 리스트로 결과를 반환합니다.",
            responses = {@ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json", schema =
                    @Schema(implementation = CommonResponse.class)))})
    @GetMapping("/list")
    public ResponseEntity<CommonResponse<List<WarehouseSection>>> warehouseSectionList(){
        List<WarehouseSection> warehouseSectionList =  warehouseSectionService.warehouseSectionList();

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWith(warehouseSectionList));
    }

    @Operation(summary = "창고구역 등록",
            description = "창고구역 등록에 알맞은 데이터를 받아 데이터베이스에 삽입합니다.",
            responses = @ApiResponse(responseCode = "201", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = CommonResponse.class))))
    @PostMapping("/insert")
    public ResponseEntity<CommonResponse<String>> insert(
            @RequestParam(required = false,defaultValue = "") @Parameter(description = "창고구역추가") String sectionName
    ){
      warehouseSectionService.insert(sectionName);

      return ResponseEntity.status(HttpStatus.CREATED)
              .contentType(MediaType.APPLICATION_JSON)
              .body(CommonResponse.successWithDefaultMessage());
    }

    @Operation(summary = "창고구역 수정",
            description = "창고구역 수정에 알맞은 데이터를 받아 데이터베이스의 데이터를 수정합니다.",
            responses = @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CommonResponse.class))))
    @PatchMapping("/modify")
    public ResponseEntity<CommonResponse<String>> modify(
            @RequestParam(required = false, defaultValue = "") @Parameter(description = "창고구역명") String sectionName,
            @RequestParam(required = false, defaultValue = "") @Parameter(description = "창고구역 넘버") Integer sectionNo
    ){
         warehouseSectionService.modify(sectionNo, sectionName);

        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWithDefaultMessage());
    }

    @Operation(summary = "창고구역 삭제",
            description = "창고구역 삭제에 알맞은 데이터를 받아 데이터베이스의 데이터를 삭제합니다.")
    @DeleteMapping("/delete")
    public ResponseEntity<CommonResponse<String>> delete(
            @RequestParam(required = false, defaultValue = "") @Parameter(description = "창고구역명") String sectionName
    )
    {
        warehouseSectionService.delete(sectionName);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWithDefaultMessage());
    }
}
