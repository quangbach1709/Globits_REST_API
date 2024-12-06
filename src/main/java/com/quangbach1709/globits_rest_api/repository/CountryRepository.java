package com.quangbach1709.globits_rest_api.repository;

import com.quangbach1709.globits_rest_api.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
