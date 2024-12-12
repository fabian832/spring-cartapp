package com.widetech.cartapp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.widetech.cartapp.entities.CartInfoEntity;

@Repository
public interface CartInfoRepo extends JpaRepository<CartInfoEntity, Integer>, JpaSpecificationExecutor<CartInfoEntity>{
    @Query(value = "SELECT DISTINCT mc.*, " +
                   "mcd.product_id AS product_id, mcd.cart_id AS cart_id  " +
                   "FROM ms_cart_detail AS mcd " +
                   "JOIN ms_cart AS mc ON mc.id = mcd.cart_id ",
           nativeQuery = true)
    List<CartInfoEntity> findAllCartInfo();
} 
