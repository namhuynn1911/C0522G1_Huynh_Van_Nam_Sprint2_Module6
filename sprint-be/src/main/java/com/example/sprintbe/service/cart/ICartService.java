package com.example.sprintbe.service.cart;

import com.example.sprintbe.dto.cart.CartDto;
import com.example.sprintbe.dto.cart.ISumCart;
import com.example.sprintbe.dto.product.IProductDto;

import java.util.List;
import java.util.Optional;

public interface ICartService {

    List<CartDto> getCart();

}
