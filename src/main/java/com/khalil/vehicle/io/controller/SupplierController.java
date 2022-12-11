package com.mukul.vehicle.io.controller;

import com.mukul.vehicle.io.model.Supplier;
import com.mukul.vehicle.io.service.CountryService;
import com.mukul.vehicle.io.service.StateService;
import com.mukul.vehicle.io.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class SupplierController {

    @Autowired
    private SupplierService supplierService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private StateService stateService;


    @GetMapping("/supplier")
    public String getSupplier(Model model) {
        model.addAttribute("suppliers", supplierService.getSuppliers());
        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("states", stateService.getStates());
        return "supplier";
    }

    @PostMapping("/supplier/addNew")
    public String addNew(Supplier supplier) {
        supplierService.save(supplier);
        return "redirect:/supplier";
    }

    @RequestMapping("/supplier/findById")
    @ResponseBody
    public Optional<Supplier> findById(Integer id) {
        return supplierService.findById(id);
    }

    @RequestMapping(value = "/supplier/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Supplier supplier) {
        supplierService.save(supplier);
        return "redirect:/supplier";
    }

    @RequestMapping(value = "/supplier/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String update(Integer id) {
        supplierService.delete(id);
        return "redirect:/supplier";
    }
}
