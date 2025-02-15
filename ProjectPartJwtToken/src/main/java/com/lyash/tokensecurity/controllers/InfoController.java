package com.lyash.tokensecurity.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class InfoController {

    @PreAuthorize("hasRole('USER')")
    @GetMapping(path = "userinfo")
    public ResponseEntity<String> getInfo(){
        return new ResponseEntity<>("info for user", HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(path = "admininfo")
    public ResponseEntity<String> getInfoA(){
        return new ResponseEntity<>("info for admin", HttpStatus.OK);
    }
}
