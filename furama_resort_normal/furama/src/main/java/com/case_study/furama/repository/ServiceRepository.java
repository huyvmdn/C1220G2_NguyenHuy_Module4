package com.case_study.furama.repository;


import com.case_study.furama.model.entity.EntityService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<EntityService,Long> {
}
