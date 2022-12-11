package com.mukul.vehicle.io.controller;

import com.mukul.vehicle.io.model.VehicleMovement;
import com.mukul.vehicle.io.service.LocationService;
import com.mukul.vehicle.io.service.VehicleMovementService;
import com.mukul.vehicle.io.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleMovementController {

    @Autowired
    private VehicleMovementService vehicleMovementService;
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private LocationService locationService;


    @GetMapping("/vehicleMovement")
    public String getVehicleMovement(Model model) {
        model.addAttribute("vehicleMovements",vehicleMovementService.getVMovements());
        model.addAttribute("vehicles", vehicleService.getVehicles());
        model.addAttribute("locations", locationService.getLocation());
        return "vehicleMovement";
    }

    @PostMapping("/vehicleMovement/addNew")
    public String addNew(VehicleMovement vehicleMovement) {
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehicleMovement";
    }

    @RequestMapping("vehicleMovement/findById")
    @ResponseBody
    public Optional<VehicleMovement> findById(Integer id) {
        return vehicleMovementService.findById(id);
    }

    @RequestMapping(value = "/vehicleMovement/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMovement vehicleMovement) {
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehicleMovement";
    }

    @RequestMapping(value = "/vehicleMovement/delete", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Integer id) {
        vehicleMovementService.delete(id);
        return "redirect:/vehicleMovement";
    }
}
