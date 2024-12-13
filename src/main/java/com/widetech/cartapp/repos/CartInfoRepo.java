package com.widetech.cartapp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.widetech.cartapp.entities.CartDetailEntity;
import com.widetech.cartapp.entities.CartInfoEntity;
import com.widetech.cartapp.globals.GlobalConstant;

@Repository
public interface CartInfoRepo extends JpaRepository<CartInfoEntity, Integer>, JpaSpecificationExecutor<CartInfoEntity>{
    @Query(value = "SELECT DISTINCT mcd.*, mc.name, mc.address, mp.name AS product_name, mp.type AS product_type, mp.price AS product_price, (mp.price*mcd.quantity) AS product_total " +
                   "FROM ms_cart_detail AS mcd " +
                   "JOIN ms_cart AS mc ON mc.id = mcd.cart_id JOIN ms_product AS mp ON mp.id = mcd.product_id WHERE mcd.rec_status LIKE '"+ GlobalConstant.REC_STATUS_ACTIVE +"'",
           nativeQuery = true)
    List<CartInfoEntity> findAll();
} 
