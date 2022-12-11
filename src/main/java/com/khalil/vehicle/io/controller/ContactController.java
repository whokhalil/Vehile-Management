package com.mukul.vehicle.io.controller;

import com.mukul.vehicle.io.model.Contact;
import com.mukul.vehicle.io.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/contacts")
    public String getContact(Model model) {
        model.addAttribute("contacts", contactService.getContacts());
        return "contact";
    }

    @PostMapping("/contacts/addNew")
    public String addNewContact(Contact contact) {
        contactService.save(contact);
        return "redirect:/contacts";
    }

    @RequestMapping("contacts/findById")
    @ResponseBody
    public Optional<Contact> findById(Integer id) {
        return contactService.findById(id);
    }

    @RequestMapping(value = "/contacts/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Contact contact) {
        contactService.save(contact);
        return "redirect:/contacts";
    }

    @RequestMapping(value = "/contacts/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String update(Integer id) {
        contactService.delete(id);
        return "redirect:/contacts";
    }
}
