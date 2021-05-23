package com.trungdoan.demosecurity.service;

import com.trungdoan.demosecurity.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CustomerService extends GeneralService<Customer> {
     boolean checkExistUser(String email);

    Page<Customer> search3 (String name, String address, String id, Pageable pageable) ;
}
