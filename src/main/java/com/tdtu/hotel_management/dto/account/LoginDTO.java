package com.tdtu.hotel_management.dto.account;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class LoginDTO {

    @Email
    private String email;
    private String password;
}
