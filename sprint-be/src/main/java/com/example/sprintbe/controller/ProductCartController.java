package com.example.sprintbe.controller;

import com.example.sprintbe.dto.CartDto;
import com.example.sprintbe.dto.product.ProductDto;
import com.example.sprintbe.service.product.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@SessionAttributes("product")
@RestController
@CrossOrigin("*")
@RequestMapping("/api/cart")
public class ProductCartController {

    @Autowired
    private IProductService iProductService;

    @ModelAttribute("product")
    public CartDto initCard() {
        return new CartDto();
    }
    @GetMapping(value = "/list")
    public ResponseEntity<Optional<ProductDto>> getList(@CookieValue(value = "idProduct", defaultValue = "-1") int idProduct) {
        Optional<ProductDto> movieList= iProductService.findById(idProduct);
        if (idProduct == -1) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    @PostMapping("/add/{id}")
    public ResponseEntity<?> addMovie(@PathVariable int id, @SessionAttribute("product") CartDto cartDto) {

        Optional<ProductDto> productOptional = iProductService.findById(id);
        if (productOptional.isPresent()) {
            cartDto.addProduct(productOptional.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
}
