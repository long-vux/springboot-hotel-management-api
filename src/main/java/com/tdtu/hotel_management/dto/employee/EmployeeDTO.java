package com.tdtu.hotel_management.dto.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EmployeeDTO {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    @Email
    private String email;

    @JsonIgnore
    private String password;

    private String phoneNumber;
    private Boolean isWomen;
    private String salary;
    private String address;
    private String department;
    private String imagePath;
    private String role;
    private String status;
}
