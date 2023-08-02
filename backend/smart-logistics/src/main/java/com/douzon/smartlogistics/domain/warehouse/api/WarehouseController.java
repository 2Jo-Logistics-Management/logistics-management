package com.douzon.smartlogistics.domain.warehouse.api;

import com.douzon.smartlogistics.domain.entity.Warehouse;
import com.douzon.smartlogistics.domain.warehouse.application.WarehouseService;
import com.douzon.smartlogistics.global.common.response.CommonResponse;
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
@RestController
@RequiredArgsConstructor
@RequestMapping("/warehouse")
public class WarehouseController {

    private WarehouseService warehouseService;
    @GetMapping("/list")
    public ResponseEntity<CommonResponse<List<Warehouse>>> searchInventoryList(
            @RequestParam(required = false, defaultValue = "") Integer warehouseSectionNO,
            @RequestParam(required = false, defaultValue = "") Integer receiveItemNo,
            @RequestParam(required = false, defaultValue = "") String itemCode
         ) {

        List<Warehouse> warehouseList = warehouseService.searchWarehouseList(warehouseSectionNO,receiveItemNo,itemCode);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWith(warehouseList));
    }
    //검색조건에 뭐 넣을지 생각해서 param에 넣어야 함



}
