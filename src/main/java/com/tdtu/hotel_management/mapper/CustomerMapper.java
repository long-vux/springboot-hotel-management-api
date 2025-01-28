package com.tdtu.hotel_management.mapper;

import com.tdtu.hotel_management.dto.customer.CustomerDTO;
import com.tdtu.hotel_management.entity.Customer;

public class CustomerMapper {
    public static CustomerDTO toCustomerDTO(Customer customer) {
        return new CustomerDTO(
            customer.getId(),
            customer.getFirstName(),
            customer.getLastName(),
            customer.getEmail(),
            customer.getIdentityNumber(),
            customer.getIdentityType(),
            customer.getPhoneNumber()
        );
    }

    public static Customer toCustomer(CustomerDTO customerDTO) {
        return new Customer(
            customerDTO.getCustomerId(),
            customerDTO.getFirstName(),
            customerDTO.getLastName(),
            customerDTO.getEmail(),
            customerDTO.getIdentityNumber(),
            customerDTO.getIdentityType(),
            customerDTO.getPhoneNumber(),
            null
        );
    }
}
