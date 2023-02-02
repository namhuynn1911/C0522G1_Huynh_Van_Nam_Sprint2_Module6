package com.example.reactjs.model;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    private boolean isDelete;
    private int price;
    private int discount;
    private int priceForSaleOff;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public Product() {
    }


    public Product(Integer id, String name, String brand, boolean isDelete, int price, int discount, int priceForSaleOff
            , Category category) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.isDelete = isDelete;
        this.price = price;
        this.discount = discount;
        this.priceForSaleOff = priceForSaleOff;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getPriceForSaleOff() {
        return priceForSaleOff;
    }

    public void setPriceForSaleOff(int priceForSaleOff) {
        this.priceForSaleOff = priceForSaleOff;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
