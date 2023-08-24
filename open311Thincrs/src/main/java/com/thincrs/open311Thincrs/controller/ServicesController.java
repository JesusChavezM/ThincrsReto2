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

    @PostMapping("/service")
    Services newService(@RequestBody Services newService) {
        return servicesRepository.save(newService);
    }

    @GetMapping("/services")
    List<Services> getAllServices() {
        return servicesRepository.findAll();
    }

    @GetMapping("/service/{id}")
    Services getServiceById(@PathVariable Long id) {
        return servicesRepository.findById(id)
                .orElseThrow(() -> new ServicesNotFoundException(id));
    }

    @PutMapping("/service/{id}")
    Services updateService(@RequestBody Services newServices, @PathVariable Long id){
        return servicesRepository.findById(id)
                .map(service ->{
                    service.setName(newServices.getName());
                    service.setCategory(newServices.getCategory());
                    service.setDescription(newServices.getDescription());
                    service.setLocation(newServices.getLocation());
                    return servicesRepository.save(service);
                }).orElseThrow(()->new ServicesNotFoundException(id));
    }

    @DeleteMapping("/service/{id}")
    String deleteService(@PathVariable Long id){
        if(!servicesRepository.existsById(id)){
            throw new ServicesNotFoundException(id);
        }
        servicesRepository.deleteById(id);
        return  "El usuario de la id: "+id+" se elimino correctamente.";
    }


}