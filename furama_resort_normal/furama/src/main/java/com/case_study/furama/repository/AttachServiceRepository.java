package com.case_study.furama.repository;


import com.case_study.furama.model.entity.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachServiceRepository extends JpaRepository<AttachService,Long> {
    AttachService findByName(String string);
}
