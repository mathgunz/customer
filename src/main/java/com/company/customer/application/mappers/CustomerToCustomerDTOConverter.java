package com.company.customer.application.mappers;

import com.company.customer.application.services.domain.Customer;
import com.company.customer.interfaces.controllers.dtos.CustomerDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CustomerToCustomerDTOConverter implements Converter<Customer, CustomerDTO> {


    @Override
    public CustomerDTO convert(Customer source) {

        return CustomerDTO.newBuilder()
                .withDocument(source.getDocument())
                .withId(source.getId())
                .withLastName(source.getLastName())
                .withName(source.getName())
                .build();
    }
}
