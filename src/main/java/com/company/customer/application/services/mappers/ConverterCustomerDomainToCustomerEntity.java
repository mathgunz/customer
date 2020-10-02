package com.company.customer.application.services.mappers;

import com.company.customer.application.services.domains.Customer;
import com.company.customer.repositories.entities.AddressEntity;
import com.company.customer.repositories.entities.CustomerEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConverterCustomerDomainToCustomerEntity implements Converter<Customer, CustomerEntity> {
    @Override
    public CustomerEntity convert(Customer source) {
        return  CustomerEntity.newBuilder()
                .withDocument(source.getDocument())
                .withLastName(source.getLastName())
                .withName(source.getName())
                .withAddressEntity(AddressEntity.newBuilder()
                        .withCity(source.getAddress().getCity())
                        .withId(source.getAddress().getId())
                        .withState(source.getAddress().getState())
                        .withZipCode(source.getAddress().getZipCode())
                        .build())
                .build();
    }
}
