package com.mukul.vehicle.io.controller;

import com.mukul.vehicle.io.model.Employee;
import com.mukul.vehicle.io.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class EmployeeController {

    //employee
    //employeeType
    //country
    //state
    //jobTitile
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeTypeService employeeTypeService;
    @Autowired
    private JobTitleService jobTitleService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private StateService stateService;

    @GetMapping("/employee")
    public String getEmployee(Model model) {
        model.addAttribute("employees", employeeService.getEmployees());
        model.addAttribute("employeeTypes", employeeTypeService.getEmployeeType());
        model.addAttribute("jobTitles", jobTitleService.getJobTitle());
        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("states", stateService.getStates());
        return "employee";
    }

    @PostMapping("/employee/addNew")
    public String addNewEmployee(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee";
    }

    @RequestMapping("employee/findById")
    @ResponseBody
    public Optional<Employee> findById(Integer id) {
        return employeeService.findById(id);
    }

    @RequestMapping(value = "/employee/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        employeeService.delete(id);
        return "redirect:/employee";
    }
}
