package com.douzon.smartlogistics.global.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommonResponse<T> {

    private final boolean success;
    private final T data;
    private final ErrorResponse<T> error;

    /**
     * 리턴 타입이 Void 일 때 사용
     */
    public static CommonResponse<String> successWithDefaultMessage() {
        return new CommonResponse<>(true, "processing complete!!", null);
    }

    /**
     * 성공한 응답에 ResponseBody를 담아 줄 때 사용
     */
    public static <T> CommonResponse<T> successWith(T data) {
        return new CommonResponse<>(true, data, null);
    }

    public static <T> CommonResponse<T> error(ErrorResponse<T> error) {
        return new CommonResponse<>(false, null, error);
    }
}
