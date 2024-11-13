package ru.itmentor.spring.boot_security.demo.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itmentor.spring.boot_security.demo.models.Person;
import ru.itmentor.spring.boot_security.demo.security.PersonDetails;

@Controller
public class HelloController {
    @GetMapping("/persons")
    public String allPersons() {
        return "persons";
    }
    @GetMapping("infoOneUser")
    public String infoOneUser(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();//помещаем в контекст данного пользователя
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        System.out.println(personDetails.getPerson());
        return "index";
    }
}
