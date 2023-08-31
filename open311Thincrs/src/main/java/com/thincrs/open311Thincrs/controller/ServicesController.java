package com.thincrs.open311Thincrs.controller;


import com.thincrs.open311Thincrs.exception.ServicesNotFoundException;
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

    @PostMapping("/services")
    Services newServices(@RequestBody Services newServices) {
        return servicesRepository.save(newServices);
    }

    @GetMapping("/services")
    List<Services> getAllServices() {
        return servicesRepository.findAll();
    }

    @GetMapping("/services/{id}")
    Services getServicesById(@PathVariable Long id) {
        return servicesRepository.findById(id)
                .orElseThrow(() -> new ServicesNotFoundException(id));
    }

    @PutMapping("/services/{id}")
    Services updateServices(@RequestBody Services newServices, @PathVariable Long id){
        return servicesRepository.findById(id)
                .map(services ->{
                    services.setName(newServices.getName());
                    services.setCategory(newServices.getCategory());
                    services.setDescription(newServices.getDescription());
                    return servicesRepository.save(services);
                }).orElseThrow(()->new ServicesNotFoundException(id));
    }

    @DeleteMapping("/services/{id}")
    String deleteServices(@PathVariable Long id){
        if(!servicesRepository.existsById(id)){
            throw new ServicesNotFoundException(id);
        }
        servicesRepository.deleteById(id);
        return  "El servicio con id: "+id+" se elimino correctamente.";
    }


}