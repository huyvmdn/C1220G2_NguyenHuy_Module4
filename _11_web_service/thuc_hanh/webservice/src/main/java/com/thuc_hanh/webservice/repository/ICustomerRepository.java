package com.thuc_hanh.webservice.repository;

import com.thuc_hanh.webservice.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICustomerRepository  extends PagingAndSortingRepository<Customer, Long> {

}
