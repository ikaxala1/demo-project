package com.girteka.assignment.services;

import com.girteka.assignment.dtos.CustomerDetailsDto;
import com.girteka.assignment.entities.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerDetailsService {
    CustomerDetailsDto getCustomerDetails(long id);
    CustomerDetailsDto customerToCustomerDetailsDto(Customer customer);
}
