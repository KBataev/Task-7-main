package ru.itmentor.spring.boot_security.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itmentor.spring.boot_security.demo.models.Person;

import javax.validation.Valid;

@Controller("/auth")
public class AuthController {

    @GetMapping("/login")
    public String loginpPage() {
        return "/auth/login";
    }

//    @GetMapping("/register")
//    public String registerPage(@ModelAttribute("person") Person person) {
//        return "/auth/register";
//    }

//    @PostMapping("/register")
//    public String performRegistracion(@ModelAttribute("person") @Valid Person person) {
//
//    }
}
