package com.trungdoan.demosecurity.repository;

import com.trungdoan.demosecurity.model.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContractRepository extends JpaRepository<Contract,Long> {


}
