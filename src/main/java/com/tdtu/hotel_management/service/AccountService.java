package com.tdtu.hotel_management.service;

import com.tdtu.hotel_management.dto.account.LoginDTO;
import com.tdtu.hotel_management.dto.account.LoginResponseDTO;
import com.tdtu.hotel_management.dto.account.RegisterDTO;
import com.tdtu.hotel_management.dto.account.RegisterResponseDTO;

public interface AccountService {

    RegisterResponseDTO registerEmployee(RegisterDTO registerDTO);
    LoginResponseDTO loginEmployee(LoginDTO loginDTO);
}