package com.mukul.vehicle.io.controller;

import com.mukul.vehicle.io.model.Location;
import com.mukul.vehicle.io.model.VehicleMake;
import com.mukul.vehicle.io.service.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleMakeController {

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @GetMapping("/vehicleMake")
    public String getLocation(Model model) {
        model.addAttribute("vehicleMakes", vehicleMakeService.getVehicleMake());
        return "vehicleMake";
    }

    @PostMapping("/vehicleMake/addNew")
    public String save(VehicleMake vehicleMake) {
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehicleMake";
    }

    @RequestMapping("/vehicleMake/findById")
    @ResponseBody
    public Optional<VehicleMake> findById(Integer id) {
        return  vehicleMakeService.findById(id);
    }

    @RequestMapping(value = "/vehicleMake/update" , method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMake vehicleMake) {
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehicleMake";
    }

    @RequestMapping(value = "/vehicleMake/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleMakeService.delete(id);
        return "redirect:/vehicleMake";
    }
}
