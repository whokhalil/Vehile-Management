package com.mukul.vehicle.io.controller;

import com.mukul.vehicle.io.model.InvoiceStatus;
import com.mukul.vehicle.io.model.VehicleMake;
import com.mukul.vehicle.io.service.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class InvoiceStatusController {

    @Autowired
    private InvoiceStatusService invoiceStatusService;

    @GetMapping("/invoiceStatus")
    public String getLocation(Model model) {
        model.addAttribute("invoiceStatuses", invoiceStatusService.getInvoiceStatus());
        return "invoiceStatus";
    }

    @PostMapping("/invoiceStatus/addNew")
    public String save(InvoiceStatus invoiceStatus) {
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/invoiceStatus";
    }

    @RequestMapping("/invoiceStatus/findById")
    @ResponseBody
    public Optional<InvoiceStatus> findById(Integer id) {
        return  invoiceStatusService.findById(id);
    }

    @RequestMapping(value = "/invoiceStatus/update" , method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(InvoiceStatus invoiceStatus) {
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/invoiceStatus";
    }

    @RequestMapping(value = "/invoiceStatus/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        invoiceStatusService.delete(id);
        return "redirect:/invoiceStatus";
    }
}
