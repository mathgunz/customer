package com.company.customer.application.services.mappers;

import com.company.customer.application.services.domains.Address;
import com.company.customer.application.services.domains.Customer;
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
                .withAddress(Address.newBuilder()
                        .withCity(source.getAddressEntity().getCity())
                        .withId(source.getAddressEntity().getId())
                        .withState(source.getAddressEntity().getState())
                        .withZipCode(source.getAddressEntity().getZipCode())
                        .build())
                .build();
    }
}
