package com.example.sprintbe.controller;


import com.example.sprintbe.dto.cart.CartDto;
import com.example.sprintbe.dto.cart.ISumCart;
import com.example.sprintbe.dto.product.IProductDto;
import com.example.sprintbe.jwt.JwtTokenUtil;
import com.example.sprintbe.payload.request.LoginRequest;
import com.example.sprintbe.payload.request.LoginResponse;
import com.example.sprintbe.repository.cart.ICartRepository;
import com.example.sprintbe.repository.product.IProductRepository;
import com.example.sprintbe.service.cart.ICartService;
import com.example.sprintbe.service.decentralization.impl.MyUserDetails;
import com.example.sprintbe.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/badminton")
public class ProductRestController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private IProductService iProductService;

    @Autowired
    private ICartService iCartService;
    @Autowired
    private ICartRepository iCartRepository;
    @Autowired
    private IProductRepository iProductRepository;

    @GetMapping("/list/home")
    public ResponseEntity<Page<IProductDto>> getAllProduct(@RequestParam(value = "name", defaultValue = "") String name,
                                                           Pageable pageable) {
        Page<IProductDto> productPage = iProductService.findAllHome(name, pageable);
        if (productPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }

    @GetMapping("/list/shoe")
    public ResponseEntity<Page<IProductDto>> getAllShoe(@RequestParam(value = "name", defaultValue = "") String name,
                                                        Pageable pageable) {
        Page<IProductDto> shoe = iProductService.findAllShoe(name, pageable);
        if (shoe.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(shoe, HttpStatus.OK);
    }

    @GetMapping(value = "/detail/{id}")
    public ResponseEntity<Optional<IProductDto>> getProductDetail(@PathVariable Integer id) {
        Optional<IProductDto> product = iProductService.getProductDetail(id);
        if (!product.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenUtil.generateJwtToken(loginRequest.getUsername());
        MyUserDetails myUserDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<String> roles = myUserDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return ResponseEntity.ok(
                new LoginResponse(
                        jwt,
                        myUserDetails.getUsername(),
                        roles));
    }

    //code Cart

    @GetMapping("/list/cart")
    public ResponseEntity<List<CartDto>> getAllCart() {
        List<CartDto> cartDtoList = iCartService.getCart();
        if (cartDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cartDtoList, HttpStatus.OK);
    }

    @GetMapping("/sumBill")
    public ResponseEntity<ISumCart> getTotalBill() {
        ISumCart iSumCart = iProductService.getSumBill();
        if (iSumCart == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iSumCart, HttpStatus.OK);
    }

    @PostMapping("/cart-update")
    public ResponseEntity<?> updateCart(@RequestParam Integer id) {
        CartDto cartDto = iCartRepository.findByIdCart(id);
        if (cartDto == null) {
            iProductService.insertToCart(id);
        } else {
            iProductService.updateCart(id);
    }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/amount-update")
    public ResponseEntity<?> updateQty(@RequestParam Integer id,
                                       @RequestParam Integer amount) {
        iProductService.updateAmount(id, amount);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/del-product")
    public ResponseEntity<?> deleteProduct(@RequestParam Integer id) {

        iProductService.deleteProduct(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
