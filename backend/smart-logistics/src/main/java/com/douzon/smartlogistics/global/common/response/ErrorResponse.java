package com.douzon.smartlogistics.global.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ErrorResponse<T> {

    private final T message;
}
