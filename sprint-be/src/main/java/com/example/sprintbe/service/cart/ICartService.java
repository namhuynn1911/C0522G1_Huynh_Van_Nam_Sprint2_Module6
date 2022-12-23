package com.example.sprintbe.service.cart;

import com.example.sprintbe.dto.cart.CartDto;
import com.example.sprintbe.dto.cart.ISumCart;
import com.example.sprintbe.dto.product.IProductDto;
import com.example.sprintbe.model.cart.Cart;

import java.util.List;
import java.util.Optional;

public interface ICartService {

    List<CartDto> getCart(Integer cartId);

    Cart findCartByUsername(String username);

    ISumCart getSumBill(Integer cartId);

    void insertToCart(Integer cart_id,Integer id);

    void updateCart(Integer id);

    IProductDto findById(Integer id, String username);

    void updateAmount(Integer id, Integer amount, Integer cartId);

//    void payment(String username);
}
