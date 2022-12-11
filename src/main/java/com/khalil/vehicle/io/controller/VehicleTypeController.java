package com.mukul.vehicle.io.controller;

import com.mukul.vehicle.io.model.VehicleMake;
import com.mukul.vehicle.io.model.VehicleType;
import com.mukul.vehicle.io.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleTypeController {

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @GetMapping("/vehicleType")
    public String getLocation(Model model) {
        model.addAttribute("vehicleTypes", vehicleTypeService.getVehicleType());
        return "vehicleType";
    }

    @PostMapping("/vehicleType/addNew")
    public String save(VehicleType vehicleType) {
        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicleType";
    }

    @RequestMapping("/vehicleType/findById")
    @ResponseBody
    public Optional<VehicleType> findById(Integer id) {
        return  vehicleTypeService.findById(id);
    }

    @RequestMapping(value = "/vehicleType/update" , method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleType vehicleType) {
        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicleType";
    }

    @RequestMapping(value = "/vehicleType/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleTypeService.delete(id);
        return "redirect:/vehicleType";
    }
}
