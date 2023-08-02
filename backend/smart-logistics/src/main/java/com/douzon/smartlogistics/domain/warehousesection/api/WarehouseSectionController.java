package com.douzon.smartlogistics.domain.warehousesection.api;

import com.douzon.smartlogistics.domain.entity.WarehouseSection;
import com.douzon.smartlogistics.domain.warehousesection.application.WarehouseSectionService;
import com.douzon.smartlogistics.global.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/warehouseSection")
public class WarehouseSectionController {

    private WarehouseSectionService warehouseSectionService;
    @GetMapping("/list")
    public ResponseEntity<CommonResponse<List<WarehouseSection>>> warehouseSectionList() {

        List<WarehouseSection> warehouseSectionList = warehouseSectionService.warehouseSectionList();

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWith(warehouseSectionList));
    }
    @GetMapping("/search")
    public ResponseEntity<CommonResponse<List<WarehouseSection>>> warehouseSectionSearch(
            @RequestParam(required = false, defaultValue = "") String warehouseSectionName
    ){
        List<WarehouseSection> warehouseSectionSearch = warehouseSectionService.warehouseSectionSearch(warehouseSectionName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWith(warehouseSectionSearch));
    }
    @PutMapping("/modify")
    public ResponseEntity<CommonResponse<String>> modify(
            @RequestParam(required = false, defaultValue = "") String warehouseSectionName
    ){
        warehouseSectionService.modify(warehouseSectionName);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWithDefaultMessage());
    }
    @DeleteMapping("/delete")
    public ResponseEntity<CommonResponse<String>> delete(
            @RequestParam(required = false,defaultValue = "") String warehouseSectionName
    ){
            warehouseSectionService.delete(warehouseSectionName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWithDefaultMessage());
    }
}
