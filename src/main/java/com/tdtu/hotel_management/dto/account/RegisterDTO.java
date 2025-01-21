package com.tdtu.hotel_management.dto.account;

import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

//@Data
@Getter
@Setter
public class RegisterDTO {

    private String firstName;
    private String lastName;

    @Email
    private String email;

    private String phoneNumber;

    private String password;

    private String confirmPassword;
}
