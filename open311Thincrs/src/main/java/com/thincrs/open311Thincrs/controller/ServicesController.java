package com.thincrs.open311Thincrs.controller;


import com.thincrs.open311Thincrs.model.Services;
import com.thincrs.open311Thincrs.repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ServicesController {

    @Autowired
    private ServicesRepository servicesRepository;

    @PostMapping("/service")
    Services newService(@RequestBody Services newService){
        return servicesRepository.save(newService);
    }

    @GetMapping("/services")
    List<Services> getAllServices() {
        return servicesRepository.findAll();
    }



}
