package com.widetech.cartapp.models;

import java.util.List;

import com.widetech.cartapp.entities.CartInfoEntity;

public class TransactionModel {
    private Integer id;
    private String name;
    private String address;
    private String recStatus;
    private List<CartInfoEntity> products;
    private Integer cartId;
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
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getRecStatus() {
        return recStatus;
    }
    public void setRecStatus(String recStatus) {
        this.recStatus = recStatus;
    }
    public List<CartInfoEntity> getProducts() {
        return products;
    }
    public void setProducts(List<CartInfoEntity> products) {
        this.products = products;
    }
    public Integer getCartId() {
        return cartId;
    }
    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }
}
