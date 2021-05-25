package com.case_study.furama.service;


import com.case_study.furama.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CustomerService extends GeneralService<Customer> {
     boolean checkExistUser(String email);

    Page<Customer> search3 (String name, String address, String id, Pageable pageable) ;

    Page<Customer> customerUsingService(Pageable pageable);
}
