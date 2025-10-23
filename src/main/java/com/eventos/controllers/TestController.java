package com.eventos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/user/profile")
    public String profile() {
        return "Accediste a un endpoint protegido con JWT";
    }
}
