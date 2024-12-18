package ru.itmentor.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import ru.itmentor.spring.boot_security.demo.models.Person;
import ru.itmentor.spring.boot_security.demo.repositories.PeopleRepository;
import ru.itmentor.spring.boot_security.demo.util.PersonNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public AdminService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }


    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Optional<Person> findById(int id) {
        Optional<Person> findPerson = peopleRepository.findById(id);
        return Optional.ofNullable(findPerson.orElseThrow(PersonNotFoundException::new));
    }

    public void update(Person updatedPerson) {
        peopleRepository.save(updatedPerson);
    }

    public void delete(int id) {
        peopleRepository.deleteById(id);
    }

}
