package com.baitap.ajax.ripository;



import com.baitap.ajax.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRipository extends JpaRepository<Category,Long> {

}
