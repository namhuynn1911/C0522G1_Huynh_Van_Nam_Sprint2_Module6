package com.example.sprintbe.repository.product;

import com.example.sprintbe.model.product.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IProductTypeRepository extends JpaRepository<ProductType, Integer> {
}
