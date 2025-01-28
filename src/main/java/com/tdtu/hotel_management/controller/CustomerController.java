package com.tdtu.hotel_management.controller;

import com.tdtu.hotel_management.dto.customer.CustomerDTO;
import com.tdtu.hotel_management.response.ApiResponse;
import com.tdtu.hotel_management.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<ApiResponse<CustomerDTO>> createCustomer(@RequestBody CustomerDTO customerDTO) {
        ApiResponse<CustomerDTO> response = customerService.createCustomer(customerDTO);
        if (!response.isSuccess()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CustomerDTO>>> getAllCustomers() {
        ApiResponse<List<CustomerDTO>> response = customerService.getAllCustomers();
        if (!response.isSuccess()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<CustomerDTO>> getCustomerById(@PathVariable("id") Long customerId) {
        ApiResponse<CustomerDTO> response = customerService.getCustomerById(customerId);
        if (!response.isSuccess()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponse<CustomerDTO>> updateCustomer(@PathVariable("id") Long customerId,
                                                                   @RequestBody CustomerDTO customerDTO) {
        ApiResponse<CustomerDTO> response = customerService.updateCustomer(customerId, customerDTO);
        if (!response.isSuccess()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<CustomerDTO>> deleteCustomer(@PathVariable("id") Long customerId) {
        ApiResponse<CustomerDTO> response = customerService.deleteCustomer(customerId);
        if (!response.isSuccess()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        return ResponseEntity.ok(response);
    }
}
