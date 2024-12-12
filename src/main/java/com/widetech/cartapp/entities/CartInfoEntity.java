package com.widetech.cartapp.entities;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "ms_cart")
public class CartInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="product_id")
    private Integer productId;

    // @Column(name="product_name")
    // private String productName;

    // @Column(name="product_type")
    // private String productType;

    // @Column(name="product_price")
    // private Long productPrice;

    // @Column(name="product_quantity")
    // private String productQuantity;

    // @Column(name="product_total")
    // private Long productTotal;

    @Column(name="created_date")
    private Timestamp createdDate;

    @Column(name="updated_date")
    private Timestamp updatedDate;

    @Column(name="deleted_date")
    private Timestamp deletedDate;

    @Column(name="rec_status")
    private String recStatus;

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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    // public String getProductName() {
    //     return productName;
    // }

    // public void setProductName(String productName) {
    //     this.productName = productName;
    // }

    // public String getProductType() {
    //     return productType;
    // }

    // public void setProductType(String productType) {
    //     this.productType = productType;
    // }

    // public Long getProductPrice() {
    //     return productPrice;
    // }

    // public void setProductPrice(Long productPrice) {
    //     this.productPrice = productPrice;
    // }

    // public String getProductQuantity() {
    //     return productQuantity;
    // }

    // public void setProductQuantity(String productQuantity) {
    //     this.productQuantity = productQuantity;
    // }

    // public Long getProductTotal() {
    //     return productTotal;
    // }

    // public void setProductTotal(Long productTotal) {
    //     this.productTotal = productTotal;
    // }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Timestamp getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Timestamp deletedDate) {
        this.deletedDate = deletedDate;
    }

    public String getRecStatus() {
        return recStatus;
    }

    public void setRecStatus(String recStatus) {
        this.recStatus = recStatus;
    }
}
