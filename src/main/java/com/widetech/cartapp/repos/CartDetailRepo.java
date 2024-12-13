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
public interface CartDetailRepo extends JpaRepository<CartDetailEntity, Integer>, JpaSpecificationExecutor<CartDetailEntity>{
    @Query(value = "SELECT mcd.*, mc.name, mc.address, mp.name AS product_name, mp.type AS product_type, mp.price AS product_price, (mp.price*mcd.quantity) AS product_total " + 
            "FROM ms_cart_detail AS mcd JOIN ms_cart_detail AS mcd ON mc.id = mcd.cart_id JOIN ms_product mp ON mp.id = mcd.product_id WHERE mc.rec_status = '" +
            GlobalConstant.REC_STATUS_NON_ACTIVE + "' AND mcd.product_id = ?1 AND mc.id = cartId", nativeQuery = true)
    CartDetailEntity findNonActivedProduct(Integer productId, Integer cartId);

    @Query(value = "SELECT COUNT(*) FROM ms_cart_detail mcd WHERE product_id = ?1 AND mcd.rec_status = '" +
            GlobalConstant.REC_STATUS_NON_ACTIVE + "'", nativeQuery = true)
    Long findProductIdInCart(Integer productId);

    @Query(value = "SELECT mcd.*, mc.name, mc.address, mp.name AS product_name, mp.type AS product_type, mp.price AS product_price, (mp.price*mcd.quantity) AS product_total " + 
            "FROM ms_cart_detail AS mcd JOIN ms_cart AS mc ON mc.id = mcd.cart_id JOIN ms_product mp ON mp.id = mcd.product_id WHERE mcd.product_id = ?1 AND mcd.cart_id = ?2", nativeQuery = true)
    CartDetailEntity findActivedProduct(Integer productId, Integer cartId);
    
    @Query(value = "SELECT DISTINCT mcd.*, mc.name, mc.address, mp.name AS product_name, mp.type AS product_type, mp.price AS product_price, (mp.price*mcd.quantity) AS product_total " +
                   "FROM ms_cart_detail AS mcd " +
                   "JOIN ms_cart AS mc ON mc.id = mcd.cart_id JOIN ms_product AS mp ON mp.id = mcd.product_id",
           nativeQuery = true)
    List<CartDetailEntity> findAllCartInfo();
} 
