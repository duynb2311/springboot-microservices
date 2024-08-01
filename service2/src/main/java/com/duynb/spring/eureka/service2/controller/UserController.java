package com.duynb.spring.eureka.service2.controller;

import com.duynb.spring.eureka.service2.authentication.JwtTokenProvider;
import com.duynb.spring.eureka.service2.dto.LoginRequestDto;
import com.duynb.spring.eureka.service2.dto.response.LoginResponseDto;
import com.duynb.spring.eureka.service2.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/")
public class UserController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("login")
    public LoginResponseDto authenticateUser(@Valid @RequestBody LoginRequestDto loginRequest) {
        return userService.authenticateUser(loginRequest);
    }
}
