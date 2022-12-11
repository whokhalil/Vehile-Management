package com.mukul.vehicle.io.controller;

import com.mukul.vehicle.io.model.Client;
import com.mukul.vehicle.io.service.ClientService;
import com.mukul.vehicle.io.service.CountryService;
import com.mukul.vehicle.io.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private StateService stateService;

    @GetMapping("/clients")
    public String getClient(Model model) {
        model.addAttribute("clients", clientService.getClients());
        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("states", stateService.getStates());
        return "clients";
    }

    @PostMapping( "/clients/addNew")
    public String addNewClient(Client client) {
        clientService.save(client);
        return "redirect:/clients";
    }

    @RequestMapping("/clients/findById")
    @ResponseBody
    public Optional<Client> findById(Integer id) {
        return clientService.findById(id);
    }

    @RequestMapping(value = "/clients/update" ,method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Client client) {
        clientService.save(client);
        return "redirect:/clients";
    }

    @RequestMapping(value = "/clients/delete" ,method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        clientService.delete(id);
        return "redirect:/clients";
    }
}
