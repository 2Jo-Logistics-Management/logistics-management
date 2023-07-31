package com.douzon.smartlogistics.domain.receiveitem.api;

import com.douzon.smartlogistics.domain.receiveitem.application.ReceiveItemService;
import com.douzon.smartlogistics.domain.receiveitem.dto.ReceiveItemInsertDto;
import com.douzon.smartlogistics.domain.receiveitem.dto.ReceiveItemModifyDto;
import com.douzon.smartlogistics.global.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/receive-item")
public class ReceiveItemController {

    private final ReceiveItemService receiveItemService;

    @PostMapping("/insert")
    public ResponseEntity<CommonResponse<String>> insertReceiveItem(@RequestBody @Valid ReceiveItemInsertDto receiveItemInsertDto){
        receiveItemService.insertReceiveItem(receiveItemInsertDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWithDefaultMessage());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<CommonResponse<String>> deleteReceiveItem(@RequestParam Long receiveItemNo) {
        receiveItemService.deleteReceiveItem(receiveItemNo);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWithDefaultMessage());
    }

    @PatchMapping("/modify")
    public ResponseEntity<CommonResponse<String>> modifyReceiveItem(
            @RequestParam Long receiveItemNo,
            @RequestBody @Valid ReceiveItemModifyDto receiveItemModifyDto
    ){
        receiveItemService.modifyReceiveItem(receiveItemNo, receiveItemModifyDto);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWithDefaultMessage());
    }

}
