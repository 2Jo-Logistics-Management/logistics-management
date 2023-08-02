package com.douzon.smartlogistics.domain.account.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@RequiredArgsConstructor
@Getter
@ToString
public class AccountInsertDto {

    @NotBlank
    @Size(max = 20)
    private final String accountName;
    @NotBlank
    @Size(max = 10)
    private final String representative;
    private final String contactNumber;
    private final String businessNumber;

    private String createIp;
    private String createId;

    public void setCreateIp(String createIp) {
        this.createIp = createIp;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }
}
