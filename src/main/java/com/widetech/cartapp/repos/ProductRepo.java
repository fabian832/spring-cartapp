package com.widetech.cartapp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.widetech.cartapp.entities.ProductEntity;
import com.widetech.cartapp.entities.TransactionInfoEntity;
import com.widetech.cartapp.globals.GlobalConstant;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Integer>, JpaSpecificationExecutor<ProductEntity>{
    @Query(value = "SELECT *" +
                   "FROM ms_product AS mp " +
                   "WHERE mp.rec_status LIKE '"+ GlobalConstant.REC_STATUS_ACTIVE +"'",
           nativeQuery = true)
    List<ProductEntity> findAll();
} 
