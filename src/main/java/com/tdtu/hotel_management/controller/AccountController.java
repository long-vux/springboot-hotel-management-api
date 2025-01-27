package com.tdtu.hotel_management.controller;

import com.tdtu.hotel_management.dto.account.LoginDTO;
import com.tdtu.hotel_management.dto.account.LoginResponseDTO;
import com.tdtu.hotel_management.dto.account.RegisterDTO;
import com.tdtu.hotel_management.dto.account.RegisterResponseDTO;
import com.tdtu.hotel_management.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> registerEmployee(@RequestBody RegisterDTO registerDTO) {
        RegisterResponseDTO response = accountService.registerEmployee(registerDTO);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> loginEmployee(@RequestBody LoginDTO loginDTO) {
        LoginResponseDTO response = accountService.loginEmployee(loginDTO);
        return ResponseEntity.ok(response);
    }
}

