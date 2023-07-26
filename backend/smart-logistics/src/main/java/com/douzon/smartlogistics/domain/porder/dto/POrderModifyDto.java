package com.douzon.smartlogistics.domain.porder.dto;

import com.douzon.smartlogistics.domain.entity.constant.State;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class POrderModifyDto {

    private String modifyIp;
    private String modifyId;
    private State state;
    private Integer accountNo;
}
