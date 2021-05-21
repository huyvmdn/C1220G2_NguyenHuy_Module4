package com.thuchanh.i18n.service;


import com.thuchanh.i18n.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {

    Page<Customer> findAll(Pageable pageable);

    Customer findById(Integer id) throws Exception;

    void save(Customer customer) throws Exception;

    void remove(Integer id) throws Exception;

    List<Customer> findAllByProvinceName(String name);

    Page<Customer> findAllByNameContaining(String name, Pageable pageable);

}