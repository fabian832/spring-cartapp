package com.widetech.cartapp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.widetech.cartapp.entities.CartInfoEntity;

@Repository
public interface CartInfoRepo extends JpaRepository<CartInfoEntity, Integer>, JpaSpecificationExecutor<CartInfoEntity>{
    @Query(value = "SELECT mc.*, mcd.product_id, mcd.quantity FROM ms_cart AS mc " + 
            "JOIN ms_cart_detail AS mcd ON mc.id = mcd.cart_id WHERE mc.rec_status = 'A'", nativeQuery = true)
    List<CartInfoEntity> findAllCartInfo();
} 
