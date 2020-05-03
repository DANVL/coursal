package com.lyash.oauth.controller;

import com.lyash.oauth.data.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class InfoController {

    @GetMapping(path = "userinfo")
    public ResponseEntity<User> getInfo(@AuthenticationPrincipal User user){
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(path = "admininfo")
    public ResponseEntity<User> getInfoA(@AuthenticationPrincipal User admin){
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }
}
