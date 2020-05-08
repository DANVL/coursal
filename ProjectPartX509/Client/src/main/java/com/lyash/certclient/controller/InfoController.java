package com.lyash.certclient.controller;

import com.lyash.certclient.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class InfoController {

    private final ServerService serverService;

    @Autowired
    public InfoController(ServerService serverService) {
        this.serverService = serverService;
    }

    @GetMapping(path = "info")
    public String userInfo()
    {
        return "User info: " + serverService.getInfo();
    }
}
