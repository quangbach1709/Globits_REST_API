package com.quangbach1709.globits_rest_api.controller;

import com.quangbach1709.globits_rest_api.model.Country;
import com.quangbach1709.globits_rest_api.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/counties")
public class CountryController {

    @Autowired
    private CountryService countryService;


    //get all countries
    @GetMapping("/all")
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    //create country
    @PostMapping("/create")
    public Country createCountry(@RequestBody Country country) {
        return countryService.createCountry(country);
    }

    //get country by id
    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable int id) {
        return countryService.getCountryById(id).orElseThrow(
                () -> new RuntimeException("Country not found with id: " + id)
        );
    }

    //update country
    @PutMapping("/{id}")
    public Country updateCountry(@PathVariable int id, @RequestBody Country country) {
        return countryService.updateCountry(id, country);
    }

    //delete country
    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable int id) {
        countryService.deleteCountry(id);
    }


}
