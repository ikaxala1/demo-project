package com.girteka.assignment.controllers;

import com.girteka.assignment.dtos.CustomerDetailsDto;
import com.girteka.assignment.services.CustomerDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerDetailsController {
    private final CustomerDetailsService customerDetailsService;

    public CustomerDetailsController(CustomerDetailsService customerDetailsService) {
        this.customerDetailsService = customerDetailsService;
    }

    @GetMapping("customer/{id}")
    public CustomerDetailsDto getCustomerDetails(@PathVariable long id) {
        return customerDetailsService.getCustomerDetails(id);
    }
}
