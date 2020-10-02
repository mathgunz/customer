package com.company.customer.application.services;

import com.company.customer.application.services.domain.Customer;
import com.company.customer.application.services.mappers.CustomerEntityToCustomerDomainConverter;
import com.company.customer.application.usecases.GetCustumerUseCase;
import com.company.customer.repositories.CustomerRepository;
import com.company.customer.repositories.entities.CustomerEntity;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    @Cacheable(cacheNames = "Customer", key="#root.method.name")
    public List<Customer> findAll() {
        return customerRepository.findAll()
                .stream()
                .map(customerEntityToCustomerDomainConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    @Cacheable(cacheNames = "Customer", key="#id")
    public Customer getCustomerById(Long id) {

        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);

        Customer customer = customerEntityToCustomerDomainConverter.convert(customerEntity.get());

        return customer;
    }

    @Override
    @CacheEvict(cacheNames = "Customer", allEntries = true)
    public Customer create(final Customer customer) {

        CustomerEntity customerEntity = customerRepository.save(CustomerEntity.newBuilder()
                .withDocument(customer.getDocument())
                .withLastName(customer.getLastName())
                .withName(customer.getName())
                .build());

        return customerEntityToCustomerDomainConverter.convert(customerEntity);
    }

    @Override
    @CachePut(cacheNames = Customer.CACHE_NAME, key="#customer.getId()")
    public Customer update(final Customer customer) {

        Optional<CustomerEntity> customerEntity = customerRepository.findById(customer.getId());

        if(!customerEntity.isPresent()) {
            throw new EntityNotFoundException("Identifier is empty");
        }

        CustomerEntity result = customerRepository.save(CustomerEntity.newBuilder()
                .withDocument(customer.getDocument())
                .withLastName(customer.getLastName())
                .withName(customer.getName())
                .build());

        return customerEntityToCustomerDomainConverter.convert(result);
    }

    @Override
    @CacheEvict(cacheNames = Customer.CACHE_NAME, key="#id")
    public void delete(final Long id) {

        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);

        if(!customerEntity.isPresent()) {
            throw new EntityNotFoundException("Identifier is empty");
        }

        customerRepository.delete(customerEntity.get());
    }
}
