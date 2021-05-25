package com.case_study.furama.repository;


import com.case_study.furama.model.entity.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceType,Long> {
    ServiceType findByName(String string);
}
