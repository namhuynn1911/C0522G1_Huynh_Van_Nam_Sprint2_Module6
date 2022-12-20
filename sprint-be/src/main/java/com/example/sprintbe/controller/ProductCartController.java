package com.example.sprintbe.controller;

import com.example.sprintbe.dto.cart.ISumCart;
import com.example.sprintbe.dto.product.ProductDto;
import com.example.sprintbe.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@SessionAttributes("product")
@RestController
@CrossOrigin("*")
@RequestMapping("/api/cart")
public class ProductCartController {

    @Autowired
    private IProductService iProductService;

    @GetMapping(value = "/list")
    public ResponseEntity<Optional<ProductDto>> getList(@CookieValue(value = "idProduct", defaultValue = "-1") int idProduct) {
        Optional<ProductDto> movieList= iProductService.findById(idProduct);
        if (idProduct == -1) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }


}
