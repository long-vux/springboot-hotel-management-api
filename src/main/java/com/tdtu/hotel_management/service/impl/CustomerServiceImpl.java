package com.tdtu.hotel_management.service.impl;

import com.tdtu.hotel_management.dto.customer.CustomerDTO;
import com.tdtu.hotel_management.entity.Customer;
import com.tdtu.hotel_management.mapper.CustomerMapper;
import com.tdtu.hotel_management.repository.CustomerRepository;
import com.tdtu.hotel_management.response.ApiResponse;
import com.tdtu.hotel_management.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public ApiResponse<CustomerDTO> createCustomer(CustomerDTO customerDTO) {
        if (customerRepository.existsByEmail(customerDTO.getEmail())) {
            return new ApiResponse<>(false, "Email already exists with customer: " + customerDTO.getEmail());
        }

        Customer customer = CustomerMapper.toCustomer(customerDTO);

        Customer savedCustomer = customerRepository.save(customer);

        CustomerDTO savedCustomerDTO = CustomerMapper.toCustomerDTO(savedCustomer);

        return new ApiResponse<>(true, "Customer created successfully", savedCustomerDTO);
    }

    @Override
    public ApiResponse<List<CustomerDTO>> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();

        List<CustomerDTO> customerDTOs = customers.stream()
                .map(CustomerMapper::toCustomerDTO)
                .collect(Collectors.toList());

        return new ApiResponse<>(true, "Successfully fetched all customers", customerDTOs);
    }

    @Override
    public ApiResponse<CustomerDTO> getCustomerById(Long customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

        if (optionalCustomer.isPresent()) {
            CustomerDTO customerDTO = CustomerMapper.toCustomerDTO(optionalCustomer.get());
            return new ApiResponse<>(true, "Customer found successfully", customerDTO);
        }

        return new ApiResponse<>(false, "Customer not found with ID: " + customerId);
    }

    @Override
    public ApiResponse<CustomerDTO> updateCustomer(Long customerId, CustomerDTO customerDTO) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();

            customer.setFirstName(customerDTO.getFirstName());
            customer.setLastName(customerDTO.getLastName());
            customer.setEmail(customerDTO.getEmail());
            customer.setIdentityNumber(customerDTO.getIdentityNumber());
            customer.setIdentityType(customerDTO.getIdentityType());
            customer.setPhoneNumber(customerDTO.getPhoneNumber());

            Customer savedCustomer = customerRepository.save(customer);

            CustomerDTO savedCustomerDTO = CustomerMapper.toCustomerDTO(savedCustomer);

            return new ApiResponse<>(true, "Customer updated successfully", savedCustomerDTO);
        }

        return new ApiResponse<>(false, "Customer not found with ID: " + customerId);
    }

    @Override
    public ApiResponse<CustomerDTO> deleteCustomer(Long customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            customerRepository.deleteById(customerId);
            return new ApiResponse<>(true, "Customer deleted successfully");
        }
        return new ApiResponse<>(false, "Customer not found with ID: " + customerId);
    }
}
