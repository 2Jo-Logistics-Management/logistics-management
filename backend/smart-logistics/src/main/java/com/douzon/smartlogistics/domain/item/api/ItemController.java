package com.douzon.smartlogistics.domain.item.api;

import com.douzon.smartlogistics.domain.entity.Item;
import com.douzon.smartlogistics.domain.item.application.ItemService;
import com.douzon.smartlogistics.domain.item.dto.ItemInsertDto;
import com.douzon.smartlogistics.domain.item.dto.ItemModifyDto;
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

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/item")
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/list")
    public ResponseEntity<CommonResponse<List<Item>>> searchItemList(
        @RequestParam(required = false) Integer itemCode,
        @RequestParam(required = false, defaultValue = "") String itemName,
        @RequestParam(required = false, defaultValue = "") String createDate,
        @RequestParam(required = false, defaultValue = "") String createId,
        @RequestParam(required = false) Integer itemPrice) {

        List<Item> itemList = itemService.searchItemList(itemCode, itemName, createDate, createId, itemPrice);

        return ResponseEntity.status(HttpStatus.OK)
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(CommonResponse.successWith(itemList));
    }

    @PostMapping("/insert")
    public ResponseEntity<CommonResponse<String>> insert(@RequestBody @Valid ItemInsertDto itemInsertDto) {
        itemService.insert(itemInsertDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(CommonResponse.successWithDefaultMessage());
    }

    @PatchMapping("/modify")
    public ResponseEntity<CommonResponse<String>> modify(@RequestParam Integer itemCode,
        @RequestBody @Valid ItemModifyDto itemModifyDto) {

        itemService.modify(itemCode, itemModifyDto);

        return ResponseEntity.status(HttpStatus.OK)
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(CommonResponse.successWithDefaultMessage());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<CommonResponse<String>> delete(@RequestParam Integer itemCode) {
        itemService.delete(itemCode);

        return ResponseEntity.status(HttpStatus.OK)
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(CommonResponse.successWithDefaultMessage());
    }
}
