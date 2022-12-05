package com.example.sprintbe.repository.product;

import com.example.sprintbe.dto.product.IProductDto;
import com.example.sprintbe.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select product.id as id, " +
            "product.name as name, " +
            "product.image as image, " +
            "product.date_of_manufacture as dateOfManufacture, " +
            "product.content as content, " +
            "product.price as price, " +
            "product.promotion as promotion, " +
            "product_type.name as productType, " +
            "producer.name as producer " +
            "from product " +
            "join product_type on product.product_type_id = product_type.id " +
            "join producer on product.producer_id = producer.id " +
            "where product.name like %:keywordName% " +
            "and product.is_delete = 0",
            countQuery = "select count (*) " +
                    "from product " +
                    "join product_type on product.product_type_id = product_type.id " +
                    "join producer on product.producer_id = producer.id " +
                    "where product.name like %:keywordName% " +
                    "and product.is_delete = 0", nativeQuery = true)
    Page<IProductDto> findAllHome(@Param("keywordName") String name, Pageable pageable);
}
