package com.widetech.cartapp.models;

public class CartModel {
    private Integer id;
    private String name;
    private String address;
    private String recStatus;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getRecStatus() {
        return recStatus;
    }
    public void setRecStatus(String recStatus) {
        this.recStatus = recStatus;
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
}
