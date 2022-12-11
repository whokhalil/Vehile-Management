package com.mukul.vehicle.io.controller;

import com.mukul.vehicle.io.model.VehicleMaintenance;
import com.mukul.vehicle.io.service.SupplierService;
import com.mukul.vehicle.io.service.VehicleMaintenanceService;
import com.mukul.vehicle.io.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VehicleMaintenanceController {

    @Autowired
    private VehicleMaintenanceService vehicleMaintenanceService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/vehicleMaintenance")
    public String getVehicleMaintenance(Model model) {
        model.addAttribute("vehicleMaintenances", vehicleMaintenanceService.getVehicleMaintenance());
        model.addAttribute("suppliers", supplierService.getSuppliers());
        model.addAttribute("vehicles", vehicleService.getVehicles());
        return "vehicleMaintenance";
    }

    @PostMapping("/vehicleMaintenance/addNew")
    public String addNewMaintenance(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehicleMaintenance";
    }
}
