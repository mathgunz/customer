package com.company.customer.application.usecases;

import com.company.customer.interfaces.controllers.dtos.CustomerDTO;

public interface GetCustumerUseCase {
    public CustomerDTO getCustomerById(Integer id);
}
