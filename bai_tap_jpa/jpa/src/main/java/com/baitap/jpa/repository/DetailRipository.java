package com.baitap.jpa.repository;

import com.baitap.jpa.entity.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRipository extends JpaRepository<Detail,Long> {
}
