package com.douzon.smartlogistics.domain.receive.api;

import com.douzon.smartlogistics.domain.entity.Receive;
import com.douzon.smartlogistics.domain.receive.application.ReceiveService;
import com.douzon.smartlogistics.global.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/receive")
public class ReceiveController {

    private final ReceiveService receiveService;

    @GetMapping("/receive-list")
    public ResponseEntity<CommonResponse<List<Receive>>> findReceive(
            @RequestParam(required = false, defaultValue = "") String receiveCode,
            @RequestParam(required = false, defaultValue = "") String manager,
            @RequestParam(required = false, defaultValue = "0") int itemCode,
            @RequestParam(required = false, defaultValue = "") String itemName,
            @RequestParam(required = false, defaultValue = "0") int accountNo,
            @RequestParam(required = false, defaultValue = "") String accountName,
            @RequestParam(required = false, defaultValue = "") String startDate,
            @RequestParam(required = false, defaultValue = "") String endDate
    ){
        List<Receive> receiveList = receiveService.findReceive(
                receiveCode, manager, itemCode, itemName, accountNo, accountName, startDate, endDate);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWith(receiveList));
    }

}
