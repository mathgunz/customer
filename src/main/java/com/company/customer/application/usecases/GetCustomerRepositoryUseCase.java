package com.company.customer.application.usecases;

import com.company.customer.application.domain.Customer;

public interface GetCustomerRepositoryUseCase {
    Customer getCustomerById(Integer id);
}
