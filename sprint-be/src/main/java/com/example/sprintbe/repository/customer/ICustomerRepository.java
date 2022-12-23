package com.example.sprintbe.repository.customer;

import com.example.sprintbe.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer where username = :username and is_delete = 0;", nativeQuery = true)
    Customer findByUsername(@Param("username") String username);
}
