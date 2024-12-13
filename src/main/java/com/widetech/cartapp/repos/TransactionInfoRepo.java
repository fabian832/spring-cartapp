package com.widetech.cartapp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.widetech.cartapp.entities.TransactionDetailEntity;
import com.widetech.cartapp.entities.TransactionInfoEntity;
import com.widetech.cartapp.globals.GlobalConstant;

@Repository
public interface TransactionInfoRepo extends JpaRepository<TransactionInfoEntity, Integer>, JpaSpecificationExecutor<TransactionInfoEntity>{
    @Query(value = "SELECT DISTINCT td.*, th.name, th.address, mp.name AS product_name, mp.type AS product_type, mp.price AS product_price, (mp.price*td.quantity) AS product_total " +
                   "FROM tr_detail AS td " +
                   "JOIN tr_header AS th ON th.id = td.transaction_id JOIN ms_product AS mp ON mp.id = td.product_id WHERE td.rec_status LIKE '"+ GlobalConstant.REC_STATUS_ACTIVE +"'",
           nativeQuery = true)
    List<TransactionInfoEntity> findAll();
} 
