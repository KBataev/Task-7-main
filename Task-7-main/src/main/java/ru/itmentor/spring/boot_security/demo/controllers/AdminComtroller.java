package ru.itmentor.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itmentor.spring.boot_security.demo.models.Person;
import ru.itmentor.spring.boot_security.demo.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminComtroller {

    private final AdminService adminService;

    @Autowired
    public AdminComtroller(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public String adminPage(Model model) {
        model.addAttribute("admin", adminService.findAll());
        return "admin";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        adminService.delete(id);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        Person person = adminService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + id));
        model.addAttribute("person", person);
        return "edit_user";
    }

    @PostMapping("/edit")
    public String updateUser(@ModelAttribute("person") Person person) {
        adminService.update(person);
        return "redirect:/admin";
    }
}

