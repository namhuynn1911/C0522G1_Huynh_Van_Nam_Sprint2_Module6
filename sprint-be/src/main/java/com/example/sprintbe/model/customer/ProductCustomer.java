package com.example.sprintbe.model.customer;


import com.example.sprintbe.model.product.Product;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_customer")
public class ProductCustomer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    private Product product;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_customer", referencedColumnName = "id")
    private Customer customer;

    @Column(name = "is_delete")
    private boolean isDelete;

    public ProductCustomer() {
    }

    public ProductCustomer(Product product, Customer customer, boolean isDelete) {
        this.product = product;
        this.customer = customer;
        this.isDelete = isDelete;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
