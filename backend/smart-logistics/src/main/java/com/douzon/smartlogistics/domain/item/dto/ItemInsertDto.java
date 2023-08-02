package com.douzon.smartlogistics.domain.item.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class ItemInsertDto {

    @NotBlank
    @Size(max = 20)
    private final String itemName;
    @NotBlank
    @Size(max = 20)
    private final String spec;
    @NotBlank
    @Size(max = 10)
    private final String unit;
    @Digits(integer = 10, fraction = 0)
    private final Integer itemPrice;
    private  String createIp;
    private  String createId;

    public void setCreateIp(String createIp) {
        this.createIp = createIp;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

}
