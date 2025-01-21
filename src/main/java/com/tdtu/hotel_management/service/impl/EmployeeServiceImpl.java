package com.tdtu.hotel_management.service.impl;

import com.tdtu.hotel_management.dto.account.LoginDTO;
import com.tdtu.hotel_management.dto.account.LoginResponseDTO;
import com.tdtu.hotel_management.dto.account.RegisterDTO;
import com.tdtu.hotel_management.dto.account.RegisterResponseDTO;
import com.tdtu.hotel_management.entity.Employee;
import com.tdtu.hotel_management.repository.EmployeeRepository;
import com.tdtu.hotel_management.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public RegisterResponseDTO registerEmployee(RegisterDTO registerDTO) {

        if (employeeRepository.existsByEmail(registerDTO.getEmail())) {
            return new RegisterResponseDTO(
                registerDTO.getEmail(),
                null,
                null,
                null,
                null,
                "Email is already registered!"
                );
        }

        Employee employee = new Employee();
        employee.setFirstName(registerDTO.getFirstName());
        employee.setLastName(registerDTO.getLastName());
        employee.setEmail(registerDTO.getEmail());
        employee.setPhoneNumber(registerDTO.getPhoneNumber());
        employee.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        employee.setRole("EMPLOYEE");

        employeeRepository.save(employee);
        return new RegisterResponseDTO(
            employee.getEmail(),
            employee.getFirstName(),
            employee.getLastName(),
            employee.getPhoneNumber(),
            employee.getRole(),
            "Employee registered successfully"
        );
    }

    @Override
    public LoginResponseDTO loginEmployee(LoginDTO loginDTO) {
        Employee employee = employeeRepository.findByEmail(loginDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email!"));

        if (!passwordEncoder.matches(loginDTO.getPassword(), employee.getPassword())) {
            return new LoginResponseDTO(employee.getEmail(), null, null, null, "Wrong password!");
        }

        return new LoginResponseDTO(
                employee.getEmail(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getRole(),
                "Employee logged in successfully!"
        );
    }
}
