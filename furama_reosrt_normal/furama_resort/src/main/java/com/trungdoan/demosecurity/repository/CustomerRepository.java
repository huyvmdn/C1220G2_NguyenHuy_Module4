package com.trungdoan.demosecurity.repository;

import com.trungdoan.demosecurity.model.entity.Customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Object findByName(String string);
    Boolean existsCustomerByEmail(String email);

    @Query(value= "select * from customer  " +
            "where name like %?1% and address like %?2% and customerType_id like %?3%", nativeQuery = true)
     Page<Customer> search3 (String name, String address, String id, Pageable pageable);
}
