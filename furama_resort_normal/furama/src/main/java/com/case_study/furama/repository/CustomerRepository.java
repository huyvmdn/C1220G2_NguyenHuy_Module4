package com.case_study.furama.repository;



import com.case_study.furama.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Object findByName(String string);
    Boolean existsCustomerByEmail(String email);

    @Query(value= "select * from customer  " +
            "where name like %?1% and address like %?2% and customerType_id like %?3%", nativeQuery = true)
     Page<Customer> search3 (String name, String address, String id, Pageable pageable);

    @Query( value =" select * from customer c inner join contract ct on ct.customer_id = c.customer_id" +
            " inner join entityservice es on es.service_id= ct.entityService_id" +
            " where ct.startDate< CURDATE() and ct.endDate >CURDATE() group by c.customer_id " , nativeQuery = true)
    Page<Customer> customerUsingService(Pageable pageable);
}
