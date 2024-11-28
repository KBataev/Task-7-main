package ru.itmentor.spring.boot_security.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itmentor.spring.boot_security.demo.service.AdminService;

import java.io.File;
import java.io.IOException;


@SpringBootApplication
public class SpringBootSecurityDemoApplication {
	public static void main(String[] args) {


		SpringApplication.run(SpringBootSecurityDemoApplication.class, args);
	}

}
