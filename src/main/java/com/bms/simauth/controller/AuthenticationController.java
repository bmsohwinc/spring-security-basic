package com.bms.simauth.controller;

import com.bms.simauth.domain.ApplicationUser;
import com.bms.simauth.domain.LoginResponseDTO;
import com.bms.simauth.domain.RegisterDTO;
import com.bms.simauth.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegisterDTO registerDTO) {
        return authenticationService.registerUser(registerDTO.getUsername(), registerDTO.getPassword());
    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegisterDTO registerDTO) {
        return authenticationService.loginUser(registerDTO.getUsername(), registerDTO.getPassword());
    }


}
