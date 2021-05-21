package com.baitap.quan_ly_sach.service;

import com.baitap.quan_ly_sach.entity.RentalCode;

public interface RentalCodeService extends GeneralService<RentalCode> {
      void deleteByCodeRentalCode(String rentalCode);
      boolean findByCodeRentalCode(String rentalCode);
}
