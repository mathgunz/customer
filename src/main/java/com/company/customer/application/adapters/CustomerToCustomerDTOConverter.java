package com.company.customer.application.adapters;

import com.company.customer.application.domain.Customer;
import com.company.customer.interfaces.controllers.dtos.CustomerDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CustomerToCustomerDTOConverter implements Converter<Customer, CustomerDTO> {


    @Override
    public CustomerDTO convert(Customer source) {

        return null;
    }
}
