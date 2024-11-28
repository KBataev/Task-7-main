package ru.itmentor.spring.boot_security.demo.RESTControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmentor.spring.boot_security.demo.models.Person;
import ru.itmentor.spring.boot_security.demo.service.AdminService;
import ru.itmentor.spring.boot_security.demo.util.PersonErrorResponse;
import ru.itmentor.spring.boot_security.demo.util.PersonNotFoundException;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/people")
public class PeopleController {

    private final AdminService adminService;

    @Autowired
    public PeopleController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public List<Person> getPeople() {
        System.out.println(adminService.findAll());
        return adminService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Person> getPersonById(@PathVariable("id") int id) {
        return adminService.findById(id);
    }

    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handleException(PersonNotFoundException e) {
        PersonErrorResponse response = new PersonErrorResponse(
                "Такого человека нету",
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
