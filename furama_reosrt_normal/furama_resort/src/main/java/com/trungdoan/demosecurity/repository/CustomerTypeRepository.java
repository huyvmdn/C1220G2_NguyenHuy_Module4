package com.trungdoan.demosecurity.repository;

import com.trungdoan.demosecurity.model.entity.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerTypeRepository extends JpaRepository<CustomerType,Long> {
    CustomerType findByName(String string);
}
