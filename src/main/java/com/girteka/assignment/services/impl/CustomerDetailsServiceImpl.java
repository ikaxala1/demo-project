package com.girteka.assignment.services.impl;

import com.girteka.assignment.data.transformations.AccountTransformer;
import com.girteka.assignment.data.transformations.CardTransformer;
import com.girteka.assignment.dtos.CustomerDetailsDto;
import com.girteka.assignment.entities.Customer;
import com.girteka.assignment.exceptions.CustomerNotFoundException;
import com.girteka.assignment.repositories.CustomerRepository;
import com.girteka.assignment.services.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
class CustomerDetailsServiceImpl implements CustomerDetailsService {
    private final Logger logger = Logger.getLogger(getClass().getName());
    private final CustomerRepository customerRepository;
    private final AccountTransformer accountTransformer;
    private final CardTransformer cardTransformer;

    @Autowired
    public CustomerDetailsServiceImpl(CustomerRepository customerRepository,
                                      AccountTransformer accountTransformer,
                                      CardTransformer cardTransformer) {
        this.customerRepository = customerRepository;
        this.accountTransformer = accountTransformer;
        this.cardTransformer = cardTransformer;
    }

    @Override
    public CustomerDetailsDto getCustomerDetails(long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
        logger.info("Found customer with given Id");
        return customerToCustomerDetailsDto(customer);
    }

    @Override
    public CustomerDetailsDto customerToCustomerDetailsDto(Customer customer) {
        return new CustomerDetailsDto(customer.getId(), customer.getFullName(), customer.getType(),
                cardTransformer.getCartDtos(customer),
                accountTransformer.getAccountDtos(customer));
    }
}
