package com.example.sprintbe.repository.customer;

import com.example.sprintbe.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
}
