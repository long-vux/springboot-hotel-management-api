package com.tdtu.hotel_management.dto.customer;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDTO {
    private Long customerId;
    private String firstName;
    private String lastName;

    @Email
    private String email;
    private String identityNumber;
    private String identityType;
    private String phoneNumber;
}
