package com.example.sdfsdf.ripository;

import com.example.sdfsdf.entity.Customer;

public interface ICustomerRepository {
    boolean insertWithStoredProcedure(Customer customer);
}