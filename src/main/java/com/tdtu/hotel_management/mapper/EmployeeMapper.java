package com.tdtu.hotel_management.mapper;

import com.tdtu.hotel_management.dto.employee.EmployeeDTO;
import com.tdtu.hotel_management.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDTO toEmployeeDto(Employee employee) {
        return new EmployeeDTO(
            employee.getId(),
            employee.getFirstName(),
            employee.getLastName(),
            employee.getDateOfBirth(),
            employee.getEmail(),
            null,
            employee.getPhoneNumber(),
            employee.getIsWomen(),
            employee.getSalary(),
            employee.getAddress(),
            employee.getDepartment(),
            employee.getImagePath(),
            employee.getRole(),
            employee.getStatus()
        );
    }

    public static Employee toEmployee(EmployeeDTO employeeDTO) {
        return new Employee(
            employeeDTO.getEmployeeId(),
            employeeDTO.getFirstName(),
            employeeDTO.getLastName(),
            employeeDTO.getEmail(),
            employeeDTO.getPassword(),
            employeeDTO.getDateOfBirth(),
            employeeDTO.getRole(),
            employeeDTO.getStatus(),
            employeeDTO.getSalary(),
            employeeDTO.getPhoneNumber(),
            employeeDTO.getIsWomen(),
            employeeDTO.getImagePath(),
            employeeDTO.getDepartment(),
            employeeDTO.getAddress()
        );
    }
}
