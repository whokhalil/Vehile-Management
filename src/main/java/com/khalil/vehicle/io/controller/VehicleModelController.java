package com.mukul.vehicle.io.controller;

import com.mukul.vehicle.io.model.VehicleMake;
import com.mukul.vehicle.io.model.VehicleModel;
import com.mukul.vehicle.io.service.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleModelController {

    @Autowired
    private VehicleModelService vehicleModelService;

    @GetMapping("/vehicleModel")
    public String getLocation(Model model) {
        model.addAttribute("vehicleModels", vehicleModelService.getVehicleModel());
        return "vehicleModel";
    }

    @PostMapping("/vehicleModel/addNew")
    public String save(VehicleModel vehicleModel) {
        vehicleModelService.save(vehicleModel);
        return "redirect:/vehicleModel";
    }

    @RequestMapping("/vehicleModel/findById")
    @ResponseBody
    public Optional<VehicleModel> findById(Integer id) {
        return  vehicleModelService.findById(id);
    }

    @RequestMapping(value = "/vehicleModel/update" , method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleModel vehicleModel) {
        vehicleModelService.save(vehicleModel);
        return "redirect:/vehicleModel";
    }

    @RequestMapping(value = "/vehicleModel/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleModelService.delete(id);
        return "redirect:/vehicleModel";
    }
}
