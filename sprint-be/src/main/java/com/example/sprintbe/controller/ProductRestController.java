package com.example.sprintbe.controller;


import com.example.sprintbe.dto.product.IProductDto;
import com.example.sprintbe.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/badminton")
public class ProductRestController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("/list/home")
    public ResponseEntity<Page<IProductDto>> getAllProduct(@RequestParam(value = "name", defaultValue = "") String name,
                                                           @PageableDefault Pageable pageable) {
        Page<IProductDto> productPage = iProductService.findAllHome(name, pageable);
        if (productPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }

}
