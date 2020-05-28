package com.example.app_login.Bean;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class CartBean implements Serializable {
    private String type_of_product;
    private int number;
    private int price_of_product;

    public CartBean(String type_of_product, int number, int price_of_product) {
        this.type_of_product = type_of_product;
        this.number = number;
        this.price_of_product = price_of_product;
    }

    public String getType_of_product() {
        return type_of_product;
    }

    public void setType_of_product(String type_of_product) {
        this.type_of_product = type_of_product;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrice_of_product() {
        return price_of_product;
    }

    public void setPrice_of_product(int price_of_product) {
        this.price_of_product = price_of_product;
    }

    @NonNull
    @Override
    public String toString() {
        return "Product{" +
                "name='" + type_of_product + '\'' +
                "number='"+ number+'\''+
                ", price='" + price_of_product + '\'' +
                '}';
    }
}
