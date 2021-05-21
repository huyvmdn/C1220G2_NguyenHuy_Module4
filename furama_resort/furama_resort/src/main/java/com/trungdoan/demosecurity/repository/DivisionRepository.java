package com.trungdoan.demosecurity.repository;

import com.trungdoan.demosecurity.model.entity.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DivisionRepository extends JpaRepository<Division,Long> {
    Division findByName(String string);
}
