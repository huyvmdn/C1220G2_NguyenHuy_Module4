package com.trungdoan.demosecurity.repository;




import com.trungdoan.demosecurity.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRipository extends JpaRepository<Category, Long> {

}
