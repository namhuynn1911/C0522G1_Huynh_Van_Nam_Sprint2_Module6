package com.example.sprintbe.model.cart;

import com.example.sprintbe.model.customer.Customer;
import com.example.sprintbe.model.decentralization.User;
import com.example.sprintbe.model.product.Product;
import com.example.sprintbe.model.product.ProductType;

import javax.persistence.*;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User username;
    private boolean is_delete;

    public Cart() {
    }

    public Cart(Integer id, User username, boolean is_delete) {
        this.id = id;
        this.username = username;
        this.is_delete = is_delete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    public boolean isIs_delete() {
        return is_delete;
    }

    public void setIs_delete(boolean is_delete) {
        this.is_delete = is_delete;
    }
}
