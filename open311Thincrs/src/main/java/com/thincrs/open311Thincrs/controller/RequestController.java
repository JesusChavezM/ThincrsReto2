package com.thincrs.open311Thincrs.controller;

import com.thincrs.open311Thincrs.exception.RequestNotFoundException;
import com.thincrs.open311Thincrs.model.Requests;
import com.thincrs.open311Thincrs.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class RequestController {

    @Autowired
    private RequestRepository requestRepository;

    @PostMapping("/requests")
    Requests newRequest(@RequestBody Requests newRequests) {
        return requestRepository.save(newRequests);
    }

    @GetMapping("/requests")
    List<Requests> getAllRequests() {
        return requestRepository.findAll();
    }

    @GetMapping("/requests/{id}")
    Requests getRequestById(@PathVariable Long id) {
        return requestRepository.findById(id)
                .orElseThrow(() -> new RequestNotFoundException(id));
    }

    @PutMapping("/requests/{id}")
    Requests updateRequest(@RequestBody Requests newRequests, @PathVariable Long id){
        return requestRepository.findById(id)
                .map(requests -> {
                    requests.setDate(newRequests.getDate());
                    requests.setStatus(newRequests.getStatus());
                    requests.setDetails(newRequests.getDetails());
                    requests.setLocate(newRequests.getLocate());
                    return requestRepository.save(requests);
                }).orElseThrow(() -> new RequestNotFoundException(id));
    }

    @DeleteMapping("/requests/{id}")
    String deleteRequest(@PathVariable Long id){
        if (!requestRepository.existsById(id)) {
            throw new RequestNotFoundException(id);
        }
        requestRepository.deleteById(id);
        return  "La solicitud con id: " + id + " se eliminó correctamente.";
    }


}