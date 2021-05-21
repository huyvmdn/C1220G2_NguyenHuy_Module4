package com.quan_ly_tinh.service;

import com.quan_ly_tinh.entity.Customer;
import com.quan_ly_tinh.entity.Province;

public interface ICustomerService extends IGeneralService<Customer> {
    public Iterable<Customer> findAllByProvince(Province province);
}
