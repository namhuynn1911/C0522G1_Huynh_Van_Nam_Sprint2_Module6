package com.example.sprintbe.model.customer;


import com.example.sprintbe.model.cart.Cart;
import com.example.sprintbe.model.product.Product;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_customer")
public class ProductCustomer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
    @Id
    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;
    private Integer amount;
    @Column(name = "is_delete")
    private boolean isDelete;
    public ProductCustomer() {
    }

    public ProductCustomer(Product product, Cart cart, Integer amount, boolean isDelete) {
        this.product = product;
        this.cart = cart;
        this.amount = amount;
        this.isDelete = isDelete;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
