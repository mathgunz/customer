package com.company.customer.interfaces.controllers;

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

    public CustomerController(GetCustumerUseCase getCustumerUseCase){
        this.getCustumerUseCase = getCustumerUseCase;
    }

    @GetMapping
    public String getCustomers(){
        return "folano1, gulano2, fulano3";
    };

    @GetMapping("{id}")
    public CustomerDTO getCustomer(@PathVariable("id") Integer id){

        CustomerDTO customerDTO = getCustumerUseCase.getCustomerById(id);
        return customerDTO;
    }


}
