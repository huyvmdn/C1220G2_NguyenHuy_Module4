package com.quan_ly_tinh.ripository;

import com.quan_ly_tinh.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IProvinceRepository extends JpaRepository<Province,Long> {
}
