package com.mukul.vehicle.io.controller;

import com.mukul.vehicle.io.model.Location;
import com.mukul.vehicle.io.service.CountryService;
import com.mukul.vehicle.io.service.LocationService;
import com.mukul.vehicle.io.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private StateService stateService;

    @GetMapping("/location")
    public String getLocation(Model model) {
        model.addAttribute("location", locationService.getLocation());
        model.addAttribute("states", stateService.getStates());
        model.addAttribute("countries", countryService.getCountries());
        return "location";
    }

    @PostMapping("/location/addNew")
    public String save(Location location) {
        locationService.save(location);
        return "redirect:/location";
    }

    @RequestMapping("/location/findById")
    @ResponseBody
    public Optional<Location> findById(Integer id) {
        return  locationService.findById(id);
    }

    @RequestMapping(value = "/location/update" , method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Location location) {
        locationService.save(location);
        return "redirect:/location";
    }

    @RequestMapping(value = "/location/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        locationService.delete(id);
        return "redirect:/location";
    }
}
