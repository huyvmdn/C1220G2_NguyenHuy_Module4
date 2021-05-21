package com.trungdoan.demosecurity.repository;

import com.trungdoan.demosecurity.model.entity.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RentTypeRepository extends JpaRepository<RentType,Long> {
    RentType findByName(String string);
}
