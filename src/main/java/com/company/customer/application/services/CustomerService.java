package com.company.customer.application.services;

import com.company.customer.application.CustomerToCustomerDTO;
import com.company.customer.application.adapters.CustomerToCustomerDTOConverter;
import com.company.customer.application.domain.Customer;
import com.company.customer.application.usecases.GetCustomerRepositoryUseCase;
import com.company.customer.application.usecases.GetCustumerUseCase;
import com.company.customer.interfaces.controllers.dtos.CustomerDTO;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements GetCustumerUseCase {


    private final GetCustomerRepositoryUseCase getCustomerRepositoryUseCase;
    private final CustomerToCustomerDTOConverter customerToCustomerDTO;

    public CustomerService(final GetCustomerRepositoryUseCase getCustomerRepositoryUseCase,
                           final CustomerToCustomerDTOConverter customerToCustomerDTO){
        this.getCustomerRepositoryUseCase = getCustomerRepositoryUseCase;
        this.customerToCustomerDTO = customerToCustomerDTO;
    }

    @Override
    public CustomerDTO getCustomerById(Integer id) {

        Customer customer = getCustomerRepositoryUseCase.getCustomerById(id);

        return customerToCustomerDTO.convert(customer);
    }
}
