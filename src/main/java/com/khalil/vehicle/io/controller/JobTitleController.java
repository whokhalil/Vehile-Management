package com.mukul.vehicle.io.controller;

import com.mukul.vehicle.io.model.JobTitle;
import com.mukul.vehicle.io.model.VehicleMake;
import com.mukul.vehicle.io.service.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class JobTitleController {

    @Autowired
    private JobTitleService jobTitleService;

    @GetMapping("/jobTitle")
    public String getLocation(Model model) {
        model.addAttribute("jobTitles", jobTitleService.getJobTitle());
        return "jobTitle";
    }

    @PostMapping("/jobTitle/addNew")
    public String save(JobTitle jobTitle) {
        jobTitleService.save(jobTitle);
        return "redirect:/jobTitle";
    }

    @RequestMapping("/jobTitle/findById")
    @ResponseBody
    public Optional<JobTitle> findById(Integer id) {
        return  jobTitleService.findById(id);
    }

    @RequestMapping(value = "/jobTitle/update" , method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(JobTitle jobTitle) {
        jobTitleService.save(jobTitle);
        return "redirect:/jobTitle";
    }

    @RequestMapping(value = "/jobTitle/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        jobTitleService.delete(id);
        return "redirect:/jobTitle";
    }
}
