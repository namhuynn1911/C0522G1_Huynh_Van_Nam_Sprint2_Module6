package com.example.sprintbe.service.product;

import com.example.sprintbe.dto.product.IProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {

    Page<IProductDto> findAllHome(String name, Pageable pageable);
}
