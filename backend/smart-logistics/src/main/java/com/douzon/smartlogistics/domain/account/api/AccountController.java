package com.douzon.smartlogistics.domain.account.api;

import com.douzon.smartlogistics.domain.account.dto.AccountInsertDto;
import com.douzon.smartlogistics.domain.account.dto.AccountModifyDto;
import com.douzon.smartlogistics.domain.entity.Account;
import com.douzon.smartlogistics.global.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.douzon.smartlogistics.domain.account.application.AccountService;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/list")
    public ResponseEntity<CommonResponse<List<Account>>> searchAccountList(
        @RequestParam(required = false) Integer accountNo,
        @RequestParam(required = false, defaultValue = "") String accountName,
        @RequestParam(required = false, defaultValue = "") String createDate,
        @RequestParam(required = false, defaultValue = "") String createId) {

        List<Account> accoutList = accountService.searchAccoutList(accountNo, accountName, createDate, createId );
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWith(accoutList));
    }

    @PostMapping("/insert")
    public ResponseEntity<CommonResponse<AccountInsertDto>> insert(@RequestBody @Valid AccountInsertDto accountInsertDto){
        accountService.insert(accountInsertDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWith(accountInsertDto));
    }

    @PatchMapping("/modify")
    public ResponseEntity<CommonResponse<String>> modify(@RequestParam Integer accountNo,
                                                         @RequestBody @Valid AccountModifyDto accountModifyDto) {

        accountService.modify(accountNo, accountModifyDto);

        return ResponseEntity.status(HttpStatus.OK)
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(CommonResponse.successWithDefaultMessage());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<CommonResponse<String>> delete(@RequestParam Integer accountNo) {
        accountService.delete(accountNo);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWithDefaultMessage());
    }
}
