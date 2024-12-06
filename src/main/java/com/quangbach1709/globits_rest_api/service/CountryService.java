package com.quangbach1709.globits_rest_api.service;

import com.quangbach1709.globits_rest_api.model.Country;
import com.quangbach1709.globits_rest_api.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service

public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public Country createCountry(Country country) {
        return countryRepository.save(country);
    }

    @Transactional
    public Optional<Country> getCountryById(int id) {
        return countryRepository.findById(id);
    }

    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Transactional
    public Country updateCountry(int id, Country country) {
        Country existingCountry = countryRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Country not found with id: " + id)
        );
        //kiem tra xem country co ton tai hay khong
        if (existingCountry != null) {
            existingCountry.setName(country.getName());
            existingCountry.setCode(country.getCode());
            existingCountry.setDescription(country.getDescription());
        }
        return countryRepository.save(existingCountry);

    }

    @Transactional
    public void deleteCountry(int id) {
        Country existingCountry = countryRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Country not found with id: " + id)
        );
        countryRepository.delete(existingCountry);
    }

}
