package com.quan_ly_tinh.ripository;


import com.quan_ly_tinh.entity.Customer;
import com.quan_ly_tinh.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long > {

    Iterable<Customer> findAllByProvince(Province province);
}
