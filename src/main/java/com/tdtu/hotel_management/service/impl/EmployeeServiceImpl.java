package com.tdtu.hotel_management.service.impl;

import com.tdtu.hotel_management.dto.employee.EmployeeDTO;
import com.tdtu.hotel_management.entity.Employee;
import com.tdtu.hotel_management.exception.EmployeeNotFoundException;
import com.tdtu.hotel_management.mapper.EmployeeMapper;
import com.tdtu.hotel_management.repository.EmployeeRepository;
import com.tdtu.hotel_management.response.ApiResponse;
import com.tdtu.hotel_management.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public ApiResponse<EmployeeDTO> createEmployee(EmployeeDTO employeeDTO) {
        if (employeeRepository.existsByEmail(employeeDTO.getEmail())) {
            return new ApiResponse<>(false, "Email already exists: " + employeeDTO.getEmail(), null);
        }
        Employee employee = EmployeeMapper.toEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDTO responseDTO = EmployeeMapper.toEmployeeDto(savedEmployee);

        return new ApiResponse<>(true, "Employee created successfully", responseDTO);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + employeeId));

        return EmployeeMapper.toEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::toEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public ApiResponse<EmployeeDTO> updateEmployee(Long employeeId, EmployeeDTO employeeDTO) {
        // Tìm employee theo ID
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);

        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();

            existingEmployee.setFirstName(employeeDTO.getFirstName());
            existingEmployee.setLastName(employeeDTO.getLastName());
            existingEmployee.setEmail(employeeDTO.getEmail());
            existingEmployee.setRole(employeeDTO.getRole());
            existingEmployee.setStatus(employeeDTO.getStatus());
            existingEmployee.setSalary(employeeDTO.getSalary());
            existingEmployee.setPhoneNumber(employeeDTO.getPhoneNumber());
            existingEmployee.setDateOfBirth(employeeDTO.getDateOfBirth());
            existingEmployee.setDepartment(employeeDTO.getDepartment());
            existingEmployee.setAddress(employeeDTO.getAddress());
            existingEmployee.setIsWomen(employeeDTO.getIsWomen());
            existingEmployee.setImagePath(employeeDTO.getImagePath());

            Employee savedEmployee = employeeRepository.save(existingEmployee);

            EmployeeDTO responseDTO = EmployeeMapper.toEmployeeDto(savedEmployee);

            return new ApiResponse<>(true, "Employee updated successfully", responseDTO);
        }
        return new ApiResponse<>(false, "Employee not found");
    }

    @Override
    public ApiResponse<EmployeeDTO> deleteEmployee(Long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (employee.isPresent()) {
            employeeRepository.deleteById(employeeId);
            return new ApiResponse<>(true, "Employee deleted successfully");
        }
        return new ApiResponse<>(false, "Employee not found");
    }
}
