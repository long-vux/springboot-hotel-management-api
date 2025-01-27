package com.tdtu.hotel_management.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;

    // use for id not found
    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
