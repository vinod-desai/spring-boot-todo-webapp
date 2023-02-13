package com.java.example.controller;

import com.java.example.service.ServiceMessageQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AboutController {

    @Autowired
    private ServiceMessageQueue serviceMessageQueue;

    @RequestMapping("/about")
    @ResponseStatus(HttpStatus.OK)
    public void getAbout() {
        serviceMessageQueue.sendMessage("getAbout called");
    }
}
