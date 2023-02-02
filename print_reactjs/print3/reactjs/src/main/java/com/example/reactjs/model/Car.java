package com.example.reactjs.model;

public class Car extends Product{
    private String color;

    public Car() {

    }

    public Car(Integer id, String name, String brand, boolean isDelete,
               int price, int discount, int priceForSaleOff, Category category, String color) {
        super(id, name, brand, isDelete, price, discount, priceForSaleOff, category);
        this.color = color;
    }
}
