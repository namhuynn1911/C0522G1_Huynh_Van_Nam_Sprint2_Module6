package com.example.sprintbe.service.product.impl;

import com.example.sprintbe.dto.product.IProductDto;
import com.example.sprintbe.dto.product.ProductDto;
import com.example.sprintbe.model.product.Product;
import com.example.sprintbe.repository.product.IProductRepository;
import com.example.sprintbe.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;


    @Override
    public Optional<ProductDto> findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public Page<IProductDto> findAllHome(String name, Pageable pageable) {
        return iProductRepository.findAllHome(name, pageable);
    }

    @Override
    public Page<IProductDto> findAllShoe(String name, Pageable pageable) {
        return iProductRepository.findAllShoe(name, pageable);
    }

    @Override
    public Optional<IProductDto> getProductDetail(Integer id) {
        return iProductRepository.productDetail(id);
    }
}
