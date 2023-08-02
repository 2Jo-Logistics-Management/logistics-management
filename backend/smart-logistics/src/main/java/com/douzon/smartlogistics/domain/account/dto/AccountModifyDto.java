package com.douzon.smartlogistics.domain.account.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@RequiredArgsConstructor
@Getter
public class AccountModifyDto {
    @NotBlank
    @Size(max = 20)
    private final String accountName;
    @NotBlank
    @Size(max = 10)
    private final String representative;
    private final String contactNumber;
    private final String businessNumber;
    private String modifyIp;
    private String modifyId;

    public void setModifyIp(String modifyIp) { this.modifyIp = modifyIp; }

    public void setModifyId(String modifyId) {
        this.modifyId = modifyId;
    }

}
