package com.company.customer.application.usecases;

import com.company.customer.application.services.domains.Customer;

import java.util.List;

public interface GetCustumerUseCase {

    public List<Customer> findAll();

    public Customer getCustomerById(Long id);

    public Customer create(final Customer customer);

    public Customer update(final Customer customer);

    public void delete(final Long id);
}
