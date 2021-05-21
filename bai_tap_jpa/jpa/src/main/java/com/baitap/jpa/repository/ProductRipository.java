package com.baitap.jpa.repository;

import com.baitap.jpa.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRipository extends JpaRepository<Product,Long> {

    @Query(value = "select * from product p" +
            " where p.name like %?1% and p.price like %?2% ",
            nativeQuery = true)
     Page<Product> search(String name, String price, Pageable pageable);

    @Query(value = "select * from product p" +
            " inner join product_cart pc on pc.product_id = p.product_id inner join cart c on c.cart_id = pc.cart_id "+
            " where p.name like %?1% and p.price like %?2% and (c.order_date between ?3  and  ?4 )",
            nativeQuery = true)
    Page<Product> searchFull(String name, String price, String date1, String date2,Pageable pageable);
}
