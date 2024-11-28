package ru.itmentor.spring.boot_security.demo.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itmentor.spring.boot_security.demo.models.Person;
import ru.itmentor.spring.boot_security.demo.service.AdminService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class JSONSave {
    private final AdminService adminService;

    @Autowired
    public JSONSave(AdminService adminService) {
        this.adminService = adminService;
    }

    @PreDestroy
    public void destroy() {
        List<Person> persons = adminService.findAll();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("persons.json"), persons);
            System.out.println("JSON файл успешно сохранен при запуске приложения.");
        } catch (IOException e) {
            e.printStackTrace();

        }

    }
}
