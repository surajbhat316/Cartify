package com.abig.Caritfy.dto.common;

import java.time.LocalDateTime;

public record ApiResponse<T>(boolean success, LocalDateTime timestamp, T data) {

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<T>(true, LocalDateTime.now(), data);
    }

    public static <T> ApiResponse<T> error(T errorDetails) {
        return new ApiResponse<T>(false, LocalDateTime.now(), errorDetails);
    }
}
