package com.tdtu.hotel_management.service;

import com.tdtu.hotel_management.dto.employee.EmployeeDTO;
import com.tdtu.hotel_management.response.ApiResponse;

import java.util.List;

public interface EmployeeService {
    ApiResponse<EmployeeDTO> createEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(Long employeeId);
    ApiResponse<EmployeeDTO> updateEmployee(Long employeeId, EmployeeDTO employeeDTO);
    ApiResponse<EmployeeDTO> deleteEmployee(Long employeeId);
}
