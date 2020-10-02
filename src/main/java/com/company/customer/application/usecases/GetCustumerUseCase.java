package com.company.customer.application.usecases;

import com.company.customer.application.services.domain.Customer;

public interface GetCustumerUseCase {
    public Customer getCustomerById(Long id);
}
