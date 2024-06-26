package com.nhnacademy.common.dto;

import java.time.LocalDateTime;
import java.util.function.Supplier;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/***
 * 기본 응답 포맷
 * @param <T> - 전달될 응답 DTO 타입
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommonResponse<T> {

    private String status;
    private T data;
    private String message;
    private LocalDateTime timestamp;

    private CommonResponse(String status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public static <T> CommonResponse<T> success(T data, String message) {
        return new CommonResponse<>("success", data, message);
    }

    public static <T> CommonResponse<T> success(T data) {
        return new CommonResponse<>("success", data, null);
    }

    public static <T> CommonResponse<T> fail(String message) {
        return new CommonResponse<>("fail", null, message);
    }

    public T dataOrElseThrow(Supplier<? extends RuntimeException> exceptionSupplier) {
        if (this.status.equals("fail")) {
            throw exceptionSupplier.get();
        }

        return this.data;
    }

}