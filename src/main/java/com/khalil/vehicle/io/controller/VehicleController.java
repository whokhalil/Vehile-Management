package com.mukul.vehicle.io.controller;

import com.mukul.vehicle.io.model.Vehicle;
import com.mukul.vehicle.io.model.VehicleMake;
import com.mukul.vehicle.io.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private VehicleTypeService vehicleTypeService;
    @Autowired
    private VehicleMakeService vehicleMakeService;
    @Autowired
    private VehicleModelService vehicleModelService;
    @Autowired
    private VehicleStatusService vehicleStatusService;
    @Autowired
    private LocationService locationService;

    @GetMapping("/vehicles")
    public String getVehicle(Model model) {
        model.addAttribute("vehicles", vehicleService.getVehicles());
        model.addAttribute("vehicleTypes", vehicleTypeService.getVehicleType());
        model.addAttribute("vehicleMakes", vehicleMakeService.getVehicleMake());
        model.addAttribute("vehicleModels", vehicleModelService.getVehicleModel());
        model.addAttribute("vehicleStatuses", vehicleStatusService.getVehicleStatus());
        model.addAttribute("locations", locationService.getLocation());
        return "vehicle";
    }

    @PostMapping("/vehicles/addNew")
    public String addNewVehicle(Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:/vehicles";
    }
}
