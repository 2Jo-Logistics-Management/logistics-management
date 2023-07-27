package com.douzon.smartlogistics.domain.receive.dto;

import com.douzon.smartlogistics.domain.receiveitem.dto.ReceiveItemDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import reactor.util.annotation.Nullable;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class ReceiveInsertDto {
    @Nullable
    private String receiveCode;
    @Nullable
    private String receiveDate;
    private String createIp;
    private String createId;
    @JsonProperty(value = "receiveItems")
    private List<ReceiveItemDto> receiveItems;
}
