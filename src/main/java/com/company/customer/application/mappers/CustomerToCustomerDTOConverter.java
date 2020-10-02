package com.company.customer.application.mappers;

import com.company.customer.application.services.domains.Customer;
import com.company.customer.interfaces.controllers.dtos.AddressDTO;
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
                .withAddressDTO(new AddressDTO(
                        source.getAddress().getId(),
                        source.getAddress().getState(),
                        source.getAddress().getCity(),
                        source.getAddress().getZipCode()))
                .build();
    }
}
