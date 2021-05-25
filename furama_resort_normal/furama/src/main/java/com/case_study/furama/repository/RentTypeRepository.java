package com.case_study.furama.repository;



import com.case_study.furama.model.entity.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RentTypeRepository extends JpaRepository<RentType,Long> {
    RentType findByName(String string);
}
