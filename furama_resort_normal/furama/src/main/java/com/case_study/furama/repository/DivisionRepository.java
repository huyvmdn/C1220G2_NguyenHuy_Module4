package com.case_study.furama.repository;


import com.case_study.furama.model.entity.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DivisionRepository extends JpaRepository<Division,Long> {
    Division findByName(String string);
}
