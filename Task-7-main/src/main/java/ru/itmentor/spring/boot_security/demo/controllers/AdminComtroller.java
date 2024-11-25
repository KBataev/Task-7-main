package ru.itmentor.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itmentor.spring.boot_security.demo.models.Person;
import ru.itmentor.spring.boot_security.demo.service.AdminService;

@Controller
public class AdminComtroller {

    private final AdminService adminService;

    @Autowired
    public AdminComtroller(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin")
    public String adminPage(Model model) {
        model.addAttribute("admin", adminService.findAll());
        return "admin";
    }

    // Удаление пользователя
    @GetMapping("/admin/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        adminService.delete(id);
        return "redirect:/admin";
    }

    // Переход на страницу редактирования
    @GetMapping("/admin/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        Person person = adminService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + id));
        model.addAttribute("person", person);
        return "edit_user";
    }

    // Сохранение изменений
    @PostMapping("/admin/edit")
    public String updateUser(@ModelAttribute("person") Person person) {
        adminService.update(person);
        return "redirect:/admin";
    }
}

