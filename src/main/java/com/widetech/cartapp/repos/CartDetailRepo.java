package com.widetech.cartapp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.widetech.cartapp.entities.CartDetailEntity;
import com.widetech.cartapp.globals.GlobalConstant;

@Repository
public interface CartDetailRepo extends JpaRepository<CartDetailEntity, Integer>, JpaSpecificationExecutor<CartDetailEntity>{
    @Query(value = "SELECT mc.*, mcd.product_id, mcd.quantity FROM ms_cart AS mc " + 
            "JOIN ms_cart_detail AS mcd ON mc.id = mcd.cart_id WHERE mc.rec_status = '" +
            GlobalConstant.REC_STATUS_NON_ACTIVE + "' AND mcd.product_id = ?1 AND mc.id = cartId", nativeQuery = true)
    CartDetailEntity findNonActivedProduct(Integer productId, Integer cartId);


    @Query(value = "SELECT mc.*, mcd.product_id, mcd.quantity FROM ms_cart AS mc " + 
            "JOIN ms_cart_detail AS mcd ON mc.id = mcd.cart_id WHERE mcd.product_id = ?1 AND mcd.cart_id = ?2", nativeQuery = true)
    CartDetailEntity findActivedProduct(Integer productId, Integer cartId);
} 
