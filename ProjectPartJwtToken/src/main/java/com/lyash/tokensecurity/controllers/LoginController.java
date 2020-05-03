package com.lyash.tokensecurity.controllers;

import com.lyash.tokensecurity.data.dto.LoginRequest;
import com.lyash.tokensecurity.data.entity.User;
import com.lyash.tokensecurity.services.TokenService;
import com.lyash.tokensecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class LoginController {

    private UserService userService;
    private TokenService tokenService;

    @Autowired
    public LoginController(UserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        User loggedUser = userService.getUser(loginRequest.getUsername(),loginRequest.getPassword());

        return new ResponseEntity<>(tokenService.tokenProvider(loggedUser), HttpStatus.OK);
    }
}
