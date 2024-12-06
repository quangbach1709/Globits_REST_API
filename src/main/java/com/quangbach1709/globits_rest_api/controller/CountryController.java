package com.quangbach1709.globits_rest_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CountryController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello world!";
    }

}