package com.tdtu.hotel_management.dto.account;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterResponseDTO {
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String role;
    private String message;
}
