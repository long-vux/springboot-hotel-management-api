package com.tdtu.hotel_management.service;

import com.tdtu.hotel_management.dto.customer.CustomerDTO;
import com.tdtu.hotel_management.response.ApiResponse;

import java.util.List;

public interface CustomerService {
    ApiResponse<CustomerDTO> createCustomer(CustomerDTO customerDTO);
    ApiResponse<List<CustomerDTO>> getAllCustomers();
    ApiResponse<CustomerDTO> getCustomerById(Long id);
    ApiResponse<CustomerDTO> updateCustomer(Long id, CustomerDTO customerDTO);
    ApiResponse<CustomerDTO> deleteCustomer(Long id);
}
