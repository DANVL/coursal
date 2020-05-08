package com.lyash.certserv.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {

    @GetMapping(path = "info")
    public String helloController() {
        String loggedUser;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            loggedUser = ((UserDetails) principal).getUsername();
        } else {
            loggedUser = principal.toString();
            System.out.println(principal);
        }
        return loggedUser;
    }
}
