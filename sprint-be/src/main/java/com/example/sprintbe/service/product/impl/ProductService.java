package com.example.sprintbe.service.product.impl;

import com.example.sprintbe.dto.cart.CartDto;
import com.example.sprintbe.dto.cart.ISumCart;
import com.example.sprintbe.dto.product.IProductDto;
import com.example.sprintbe.dto.product.ProductDto;
import com.example.sprintbe.model.product.Product;
import com.example.sprintbe.repository.cart.ICartRepository;
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
    @Autowired
    private ICartRepository iCartRepository;


    @Override
    public Optional<ProductDto> findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public Page<IProductDto> findAllHome(String name, Pageable pageable) {
        return iProductRepository.findAllHome(name, pageable);
    }

    @Override
    public Page<IProductDto> findAllYonex(String name, Pageable pageable) {
        return iProductRepository.findAllYonex(name, pageable);
    }

    @Override
    public Page<IProductDto> findAllShoe(String name, Pageable pageable) {
        return iProductRepository.findAllShoe(name, pageable);
    }

    @Override
    public Optional<IProductDto> getProductDetail(Integer id) {
        return iProductRepository.productDetail(id);
    }

//    @Override
//    public CartDto findById(Integer id) {
//        return iCartRepository.findByIdCart(id);
//    }

//    @Override
//    public void updateAmount(Integer id, Integer amount) {
//        iCartRepository.updateAmount(id, amount);
//    }

    @Override
    public void deleteProduct(Integer id) {
        iCartRepository.deleteProduct(id);
    }
}
