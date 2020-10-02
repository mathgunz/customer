package com.company.customer.interfaces.controllers;

import com.company.customer.application.mappers.CustomerToCustomerDTOConverter;
import com.company.customer.application.services.domain.Customer;
import com.company.customer.application.usecases.GetCustumerUseCase;
import com.company.customer.interfaces.controllers.dtos.CustomerDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/customers")
@RestController
public class CustomerController {

    private final GetCustumerUseCase getCustumerUseCase;
    private final CustomerToCustomerDTOConverter customerToCustomerDTO;

    public CustomerController(GetCustumerUseCase getCustumerUseCase,
                              CustomerToCustomerDTOConverter customerToCustomerDTO){
        this.getCustumerUseCase = getCustumerUseCase;
        this.customerToCustomerDTO = customerToCustomerDTO;
    }

    @GetMapping
    public String getCustomers(){
        return "folano1, gulano2, fulano3";
    };

    @GetMapping("{id}")
    public CustomerDTO getCustomer(@PathVariable("id") Long id){

        Customer customer = getCustumerUseCase.getCustomerById(id);

        CustomerDTO customerDTO = customerToCustomerDTO.convert(customer);

        return customerDTO;
    }


}
