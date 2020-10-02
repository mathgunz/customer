package com.company.customer.repositories;

import com.company.customer.application.domain.Customer;
import com.company.customer.application.usecases.GetCustomerRepositoryUseCase;
import org.springframework.stereotype.Service;

@Service
public class CustomerRepository  implements GetCustomerRepositoryUseCase {

    @Override
    public Customer getCustomerById(Integer id) {

        Customer customer = Customer.newBuilder()
                .withId(10)
                .withName("Matheus")
                .withLastName("graciano")
                .withDocument("417.585.987-02")
                .build();

        return customer;
    }
}
