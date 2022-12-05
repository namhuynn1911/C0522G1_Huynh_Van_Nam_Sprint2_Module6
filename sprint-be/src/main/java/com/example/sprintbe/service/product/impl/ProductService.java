package com.example.sprintbe.service.product.impl;

import com.example.sprintbe.dto.product.IProductDto;
import com.example.sprintbe.repository.product.IProductRepository;
import com.example.sprintbe.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;


    @Override
    public Page<IProductDto> findAllHome(String name, Pageable pageable) {
        return iProductRepository.findAllHome(name, pageable);
    }
}
