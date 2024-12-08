package com.quangbach1709.globits_rest_api.service;

import com.quangbach1709.globits_rest_api.model.Person;
import com.quangbach1709.globits_rest_api.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Optional<Person> getPersonById(int id) {
        return personRepository.findById(id);
    }

    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    public Person updatePerson(int id, Person person) {
        Person person1 = personRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Person not found for id: " + id)
        );
        return personRepository.save(person);
    }

    public void deletePerson(int id) {
        Person person = personRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Person not found for id: " + id)
        );
        personRepository.deleteById(id);
    }
}
