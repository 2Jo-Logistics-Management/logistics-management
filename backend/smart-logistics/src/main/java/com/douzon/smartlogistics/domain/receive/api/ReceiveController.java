package com.douzon.smartlogistics.domain.receive.api;

import com.douzon.smartlogistics.domain.entity.ReceiveList;
import com.douzon.smartlogistics.domain.entity.CmpPOrder;
import com.douzon.smartlogistics.domain.receive.application.ReceiveService;
import com.douzon.smartlogistics.domain.receive.dto.ReceiveInsertDto;
import com.douzon.smartlogistics.global.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/receive")
public class ReceiveController {

    private final ReceiveService receiveService;

    @GetMapping("/list")
    public ResponseEntity<CommonResponse<List<ReceiveList>>> findReceive(
            @RequestParam(required = false, defaultValue = "") String receiveCode,
            @RequestParam(required = false, defaultValue = "") String manager,
            @RequestParam(required = false, defaultValue = "0") Integer itemCode,
            @RequestParam(required = false, defaultValue = "") String itemName,
            @RequestParam(required = false, defaultValue = "0") Integer accountNo,
            @RequestParam(required = false, defaultValue = "") String accountName,
            @RequestParam(required = false, defaultValue = "") String startDate,
            @RequestParam(required = false, defaultValue = "") String endDate
    ){
        List<ReceiveList> receiveList = receiveService.findReceive(
                receiveCode, manager, itemCode, itemName, accountNo, accountName, startDate, endDate);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWith(receiveList));
    }

    @GetMapping("/insert")
    public ResponseEntity<CommonResponse<List<CmpPOrder>>> waitingReceive(
            @RequestParam(required = false, defaultValue = "") String porderCode,
            @RequestParam(required = false, defaultValue = "0") Integer itemCode,
            @RequestParam(required = false, defaultValue = "") String itemName,
            @RequestParam(required = false, defaultValue = "") String manager,
            @RequestParam(required = false, defaultValue = "0") Integer accountNo,
            @RequestParam(required = false, defaultValue = "") String accountName,
            @RequestParam(required = false, defaultValue = "") String startDate,
            @RequestParam(required = false, defaultValue = "") String endDate
    ){
        List<CmpPOrder> cmpPOrderList = receiveService.waitingReceive(
                porderCode, itemCode, itemName, manager, accountNo, accountName, startDate, endDate
        );
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWith(cmpPOrderList));
    }

    @PostMapping("/insert")
    public ResponseEntity<CommonResponse<String>> insertReceive(@RequestBody List<Map<String,Object>> receiveList){

        String createIp = "192.168.0.250";
        String createId = "admin";

        Map<String, Object> map = new HashMap<>();
        map.put("createIp", createIp);
        map.put("createId", createId);
        map.put("receiveList",receiveList);
        System.out.println("map = " + map);
        receiveService.insertReceive(map);

        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWithDefaultMessage());
    }



    @DeleteMapping("/delete")
    public ResponseEntity<CommonResponse<String>> deleteReceive(@RequestParam String receiveCode){
        receiveService.deleteReceive(receiveCode);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWithDefaultMessage());
    }

    @DeleteMapping("/delete/receive-item")
    public ResponseEntity<CommonResponse<String>> deleteReceiveItem(@RequestParam Long receiveItemNo) {
        receiveService.deleteReceiveItem(receiveItemNo);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWithDefaultMessage());
    }

}
