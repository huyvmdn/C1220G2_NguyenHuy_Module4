package com.case_study.furama.service.impl;


import com.case_study.furama.model.entity.Customer;
import com.case_study.furama.repository.CustomerRepository;
import com.case_study.furama.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteById(Long idDelete) {
        customerRepository.deleteById(idDelete);
    }


    @Override
    public boolean checkExistUser(String email) {
        return customerRepository.existsCustomerByEmail(email);
    }

    @Override
    public Page<Customer> search3(String name, String address, String id, Pageable pageable) {
        return customerRepository.search3(name,address,id,pageable);
    }

    @Override
    public Page<Customer> customerUsingService(Pageable pageable) {
        return customerRepository.customerUsingService(pageable);
    }
}
