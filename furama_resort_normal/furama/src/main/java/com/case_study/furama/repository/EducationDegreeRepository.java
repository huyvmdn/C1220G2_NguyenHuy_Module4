package com.case_study.furama.repository;



import com.case_study.furama.model.entity.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EducationDegreeRepository extends JpaRepository<EducationDegree,Long> {
    EducationDegree findByName(String string);
}
