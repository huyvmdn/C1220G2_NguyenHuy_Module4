package com.baitap.quan_ly_sach.repository;

import com.baitap.quan_ly_sach.entity.RentalCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RentalCodeRepository extends JpaRepository<RentalCode,Long> {
     RentalCode deleteByCodeRentalCode(String rentalCode);
    RentalCode findFirstByCodeRentalCode(String rentalCode);
    RentalCode findByCodeRentalCode(String rentalCode);
}
