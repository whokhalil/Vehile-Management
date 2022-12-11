package com.mukul.vehicle.io.controller;

import com.mukul.vehicle.io.model.EmployeeType;
import com.mukul.vehicle.io.model.VehicleMake;
import com.mukul.vehicle.io.service.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class EmployeeTypeController {

    @Autowired
    private EmployeeTypeService employeeTypeService;

    @GetMapping("/employeeType")
    public String getLocation(Model model) {
        model.addAttribute("employeeTypes", employeeTypeService.getEmployeeType());
        return "employeeType";
    }

    @PostMapping("/employeeType/addNew")
    public String save(EmployeeType employeeType) {
        employeeTypeService.save(employeeType);
        return "redirect:/employeeType";
    }

    @RequestMapping("/employeeType/findById")
    @ResponseBody
    public Optional<EmployeeType> findById(Integer id) {
        return  employeeTypeService.findById(id);
    }

    @RequestMapping(value = "/employeeType/update" , method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(EmployeeType employeeType) {
        employeeTypeService.save(employeeType);
        return "redirect:/employeeType";
    }

    @RequestMapping(value = "/employeeType/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        employeeTypeService.delete(id);
        return "redirect:/employeeType";
    }
}
