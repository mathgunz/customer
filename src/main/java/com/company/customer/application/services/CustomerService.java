package com.company.customer.application.services;

import com.company.customer.application.services.domain.Customer;
import com.company.customer.application.services.mappers.CustomerEntityToCustomerDomainConverter;
import com.company.customer.application.usecases.GetCustumerUseCase;
import com.company.customer.repositories.CustomerRepository;
import com.company.customer.repositories.entities.CustomerEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements GetCustumerUseCase {

    private final CustomerRepository customerRepository;
    private final CustomerEntityToCustomerDomainConverter customerEntityToCustomerDomainConverter;

    public CustomerService(final CustomerRepository customerRepository,
                           final CustomerEntityToCustomerDomainConverter customerEntityToCustomerDomainConverter){
        this.customerRepository = customerRepository;
        this.customerEntityToCustomerDomainConverter = customerEntityToCustomerDomainConverter;
    }

    @Override
    public Customer getCustomerById(Long id) {

        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);

        Customer customer = customerEntityToCustomerDomainConverter.convert(customerEntity.get());

        return customer;
    }
}
