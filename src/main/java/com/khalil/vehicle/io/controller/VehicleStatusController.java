package com.mukul.vehicle.io.controller;

import com.mukul.vehicle.io.model.VehicleMake;
import com.mukul.vehicle.io.model.VehicleStatus;
import com.mukul.vehicle.io.service.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleStatusController {

    @Autowired
    private VehicleStatusService vehicleStatusService;

    @GetMapping("/vehicleStatus")
    public String getLocation(Model model) {
        model.addAttribute("vehicleStatuses", vehicleStatusService.getVehicleStatus());
        return "vehicleStatus";
    }

    @PostMapping("/vehicleStatus/addNew")
    public String save(VehicleStatus vehicleStatus) {
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehicleStatus";
    }

    @RequestMapping("/vehicleStatus/findById")
    @ResponseBody
    public Optional<VehicleStatus> findById(Integer id) {
        return  vehicleStatusService.findById(id);
    }

    @RequestMapping(value = "/vehicleStatus/update" , method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleStatus vehicleStatus) {
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehicleStatus";
    }

    @RequestMapping(value = "/vehicleStatus/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleStatusService.delete(id);
        return "redirect:/vehicleStatus";
    }
}
