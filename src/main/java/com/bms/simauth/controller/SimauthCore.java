package com.bms.simauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimauthCore {

    @GetMapping
    public String hello() {
        return "Hello World";
    }

}
