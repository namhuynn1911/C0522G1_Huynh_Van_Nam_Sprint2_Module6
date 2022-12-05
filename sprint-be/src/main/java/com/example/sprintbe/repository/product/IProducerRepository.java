package com.example.sprintbe.repository.product;

import com.example.sprintbe.model.product.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IProducerRepository extends JpaRepository<Producer, Integer> {
}
