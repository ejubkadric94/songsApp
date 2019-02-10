package com.media.server.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("/hello/{name}")
    String ehello(@PathVariable String name) {
        return "tralalal, " + name + "!";
    }

    @RequestMapping("/hello")
    String hello2() {
        return "15";
    }
}
