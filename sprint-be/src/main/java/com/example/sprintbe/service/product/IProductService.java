package com.example.sprintbe.service.product;

import com.example.sprintbe.dto.product.IProductDto;
import com.example.sprintbe.dto.product.ProductDto;
import com.example.sprintbe.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {

    Optional<ProductDto> findById(int id);

    Page<IProductDto> findAllHome(String name, Pageable pageable);

    Page<IProductDto> findAllShoe(String name, Pageable pageable);

    Optional<IProductDto> getProductDetail(Integer id);
}
