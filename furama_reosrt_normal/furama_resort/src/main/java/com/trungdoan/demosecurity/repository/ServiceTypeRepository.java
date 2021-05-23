package com.trungdoan.demosecurity.repository;

import com.trungdoan.demosecurity.model.entity.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceType,Long> {
    ServiceType findByName(String string);
}
