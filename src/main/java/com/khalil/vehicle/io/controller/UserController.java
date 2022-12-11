package com.mukul.vehicle.io.controller;

import com.mukul.vehicle.io.model.User;
import com.mukul.vehicle.io.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getUser() {
        return "user";
    }

    @PostMapping("/users/addNew")
    public RedirectView addNewUser(User user, RedirectAttributes redirectAttributes) {
        userService.save(user);

        RedirectView redirectView = new RedirectView("/login", true);
        redirectAttributes.addFlashAttribute("message", "You are successfully registered!");

        return redirectView;
    }
}
