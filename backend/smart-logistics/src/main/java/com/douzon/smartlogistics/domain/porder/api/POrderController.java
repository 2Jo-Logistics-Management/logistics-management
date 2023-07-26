package com.douzon.smartlogistics.domain.porder.api;

import com.douzon.smartlogistics.domain.entity.POrder;
import com.douzon.smartlogistics.domain.entity.constant.State;
import com.douzon.smartlogistics.domain.porder.application.POrderService;
import com.douzon.smartlogistics.domain.porder.dto.POrderInsertDto;
import com.douzon.smartlogistics.domain.porder.dto.POrderModifyDto;
import com.douzon.smartlogistics.global.common.response.CommonResponse;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/porder")
@Slf4j
public class POrderController {

    private final POrderService pOrderService;

    @GetMapping("/list")
    public ResponseEntity<CommonResponse<List<POrder>>> searchPOrderList(
        @RequestParam(required = false, defaultValue = "") String pOrderCode,
        @RequestParam(required = false) State state,
        @RequestParam(required = false, defaultValue = "") String createId,
        @RequestParam(required = false, defaultValue = "") String createIp,
        @RequestParam(required = false) Long accountNo,
        @RequestParam(required = false, defaultValue = "") String startDate,
        @RequestParam(required = false, defaultValue = "") String endDate,
        @RequestParam(required = false, defaultValue = "") String pOrderDate
    ) {

        List<POrder> pOrderList = pOrderService.searchPOrder(pOrderCode, state, createId, createIp, accountNo,
            startDate, endDate, pOrderDate);

        return ResponseEntity.status(HttpStatus.OK)
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(CommonResponse.successWith(pOrderList));
    }

    @PostMapping("/insert")
    public ResponseEntity<CommonResponse<String>> insert(@RequestBody @Valid POrderInsertDto pOrderInsertDto) {
        pOrderService.insert(pOrderInsertDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(CommonResponse.successWithDefaultMessage());
    }

    @PatchMapping("/modify")
    public ResponseEntity<CommonResponse<String>> modify(@RequestParam String pOrderCode,
        @RequestBody @Valid POrderModifyDto pOrderModifyDto) {

        pOrderService.modify(pOrderCode, pOrderModifyDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(CommonResponse.successWithDefaultMessage());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<CommonResponse<String>> delete(@RequestParam String pOrderCode) {

        pOrderService.delete(pOrderCode);

        return ResponseEntity.status(HttpStatus.CREATED)
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(CommonResponse.successWithDefaultMessage());
    }
}
