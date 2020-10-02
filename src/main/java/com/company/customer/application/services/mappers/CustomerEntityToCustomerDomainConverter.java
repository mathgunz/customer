package com.company.customer.application.services.mappers;

import com.company.customer.application.services.domain.Customer;
import com.company.customer.repositories.entities.CustomerEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CustomerEntityToCustomerDomainConverter implements Converter<CustomerEntity, Customer> {

    @Override
    public Customer convert(CustomerEntity source) {
        return Customer.newBuilder()
                .withDocument(source.getDocument())
                .withId(source.getId())
                .withLastName(source.getLastName())
                .withName(source.getName())
                .build();
    }
}
