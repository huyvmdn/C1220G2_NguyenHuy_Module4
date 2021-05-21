package com.example.sdfsdf.service;

import com.example.sdfsdf.entity.Customer;

public interface ICustomerService {
    boolean insertWithStoredProcedure(Customer customer);
}