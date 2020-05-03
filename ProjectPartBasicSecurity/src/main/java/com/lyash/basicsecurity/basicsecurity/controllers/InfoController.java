package com.lyash.basicsecurity.basicsecurity.controllers;

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

    @GetMapping(path = "userinfo")
    public ResponseEntity<String> getInfo(){
        return new ResponseEntity<>("info for user", HttpStatus.OK);
    }

    @GetMapping(path = "admininfo")
    public ResponseEntity<String> getInfoA(){
        return new ResponseEntity<>("info for admin", HttpStatus.OK);
    }
}
