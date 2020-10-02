package com.company.customer.interfaces.controllers;

import com.company.customer.application.mappers.CustomerToCustomerDTOConverter;
import com.company.customer.application.services.domains.Address;
import com.company.customer.application.services.domains.Customer;
import com.company.customer.application.usecases.GetCustumerUseCase;
import com.company.customer.interfaces.controllers.dtos.CustomerDTO;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

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


    @GetMapping("{id}")
    public CustomerDTO get(@PathVariable("id") Long id){

        Customer customer = getCustumerUseCase.getCustomerById(id);

        return customerToCustomerDTO.convert(customer);
    }

    @GetMapping
    public List<CustomerDTO> findAll() {
        return getCustumerUseCase.findAll().stream().map(customerToCustomerDTO::convert).collect(Collectors.toList());
    }

    @PostMapping
    public CustomerDTO create(@RequestBody CustomerDTO customerDTO) {

        Customer customer = getCustumerUseCase.create(this.converterDtoTDomain(customerDTO));

        return customerToCustomerDTO.convert(customer);
    }

    @PutMapping("{id}")
    public CustomerDTO update(@RequestBody CustomerDTO customerDTO, @PathVariable Long id) {


        Customer result = getCustumerUseCase.update(Customer.newBuilder()
                .withId(id)
                .withName(customerDTO.getName())
                .withLastName(customerDTO.getLastName())
                .withDocument(customerDTO.getDocument())
                .build());

        return customerToCustomerDTO.convert(result);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        getCustumerUseCase.delete(id);
    }

    private Customer converterDtoTDomain(CustomerDTO customerDTO) {

        return Customer.newBuilder()
                .withName(customerDTO.getName())
                .withLastName(customerDTO.getLastName())
                .withDocument(customerDTO.getDocument())
                .withAddress(Address.newBuilder()
                        .withZipCode(customerDTO.getAddress().getZipCode())
                        .withState(customerDTO.getAddress().getState())
                        .withId(customerDTO.getAddress().getId())
                        .withCity(customerDTO.getAddress().getCity())
                        .build())
                .build();
    }
}
