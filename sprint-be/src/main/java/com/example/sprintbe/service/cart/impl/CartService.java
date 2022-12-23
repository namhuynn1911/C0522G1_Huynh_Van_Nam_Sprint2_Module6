package com.example.sprintbe.service.cart.impl;

import com.example.sprintbe.dto.cart.CartDto;
import com.example.sprintbe.dto.cart.ISumCart;
import com.example.sprintbe.dto.product.IProductDto;
import com.example.sprintbe.model.cart.Cart;
import com.example.sprintbe.model.customer.Customer;
import com.example.sprintbe.repository.cart.ICartRepository;
import com.example.sprintbe.repository.customer.ICustomerRepository;
import com.example.sprintbe.repository.product.IProductRepository;
import com.example.sprintbe.service.cart.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService implements ICartService {

    @Autowired
    private ICartRepository iCartRepository;
    @Autowired
    private IProductRepository iProductRepository;
    @Autowired
    private ICustomerRepository iCustomerRepository;


    @Override
    public List<CartDto> getCart(Integer cartId) {
        return iCartRepository.productCart(cartId);
    }

    @Override
    public Cart findCartByUsername(String username) {
        return iCartRepository.findCartId(username);
    }

    @Override
    public ISumCart getSumBill(Integer cartId) {
        return iCartRepository.sumCart(cartId);
    }

    @Override
    public void insertToCart(Integer cart_id,Integer id) {
        iCartRepository.insertToCart(cart_id,id);
    }

    @Override
    public void updateCart(Integer id) {
        iCartRepository.updateCart(id);
    }

    @Override
    public IProductDto findById(Integer id, String username) {
        return iCartRepository.findByIdCart(id,username);
    }

    @Override
    public void updateAmount(Integer id, Integer amount, Integer cartId) {
        iCartRepository.updateAmount(id,amount,cartId);
    }

//    @Override
//    public void payment(String username) {
//        iCartRepository.payment(username);
//    }

}
