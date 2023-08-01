package com.douzon.smartlogistics.domain.porder.dto;

import com.douzon.smartlogistics.domain.porderitem.dto.POrderItemInsertDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.validation.constraints.Digits;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class POrderInsertDto {

    @Nullable
    private String pOrderCode;
    @Nullable
    private String pOrderDate;
    private String createIp;
    private String createId;
    @Digits(integer = 10, fraction = 0)
    private Integer accountNo;
    @JsonProperty(value = "pOrderItems")
    private List<POrderItemInsertDto> pOrderItems;
}
