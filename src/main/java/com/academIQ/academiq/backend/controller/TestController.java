package com.academIQ.academiq.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @GetMapping("/")
    public String home() {
        return "Backend AcademIQ conectado correctamente con Oracle!";
    }
}