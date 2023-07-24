package com.douzon.smartlogistics.domain.porder.api;

import com.douzon.smartlogistics.domain.entity.POrder;
import com.douzon.smartlogistics.domain.entity.constant.State;
import com.douzon.smartlogistics.domain.porder.application.POrderService;
import com.douzon.smartlogistics.global.common.response.CommonResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/porder")
@Slf4j
public class POrderController {

    private final POrderService pOrderService;

    @GetMapping("/list")
    public ResponseEntity<CommonResponse<List<POrder>>> searchPOrderList(
        @RequestParam(required = false, defaultValue = "") String POrderCode,
        @RequestParam(required = false) State state,
        @RequestParam(required = false, defaultValue = "") String createId,
        @RequestParam(required = false, defaultValue = "") String createIp,
        @RequestParam(required = false) Long accountNo,
        @RequestParam(required = false, defaultValue = "") String startDate,
        @RequestParam(required = false, defaultValue = "") String endDate
    ) {

        List<POrder> pOrderList = pOrderService.searchPOrder(POrderCode, state, createId, createIp, accountNo,
            startDate, endDate);

        return ResponseEntity.status(HttpStatus.OK)
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(CommonResponse.successWith(pOrderList));
    }
}
