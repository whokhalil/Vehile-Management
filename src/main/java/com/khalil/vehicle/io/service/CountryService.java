package com.mukul.vehicle.io.service;

import com.mukul.vehicle.io.model.Country;
import com.mukul.vehicle.io.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    //Return List of Countries
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    //Save New Country
    public void save(Country country) {
        countryRepository.save(country);
    }

    //Get by Id
    public Optional<Country> findById(Integer id) {
        return countryRepository.findById(id);
    }

    //Delete service
    public void delete(Integer id) {
        countryRepository.deleteById(id);
    }
}
