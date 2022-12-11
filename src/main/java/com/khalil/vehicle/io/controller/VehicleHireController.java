package com.mukul.vehicle.io.controller;

import com.mukul.vehicle.io.model.VehicleHire;
import com.mukul.vehicle.io.service.ClientService;
import com.mukul.vehicle.io.service.LocationService;
import com.mukul.vehicle.io.service.VehicleHireService;
import com.mukul.vehicle.io.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class VehicleHireController {

    @Autowired
    private VehicleHireService vehicleHireService;
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private LocationService locationService;

    @GetMapping("/vehicleHires")
    public String getVehicleHire(Model model) {
        model.addAttribute("vehicleHires", vehicleHireService.getHires());
        model.addAttribute("vehicles", vehicleService.getVehicles());
        model.addAttribute("clients", clientService.getClients());
        model.addAttribute("locations", locationService.getLocation());
        return "vehicleHire";
    }

    @PostMapping("/vehicleHires/addNew")
    public String addNew(VehicleHire vehicleHire) {
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehicleHires";
    }

    @RequestMapping("vehicleHires/findById")
    public Optional<VehicleHire> findById(Integer id) {
        return vehicleHireService.findById(id);
    }

    @RequestMapping(value = "/vehicleHires/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleHire vehicleHire) {
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehicleHires";
    }

    @RequestMapping(value = "/vehicleHires/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleHireService.delete(id);
        return "redirect:/vehicleHires";
    }

}
