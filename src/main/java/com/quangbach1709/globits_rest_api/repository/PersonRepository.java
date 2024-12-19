package com.quangbach1709.globits_rest_api.repository;

import com.quangbach1709.globits_rest_api.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {


}
