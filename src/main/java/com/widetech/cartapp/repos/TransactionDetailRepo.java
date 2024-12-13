package com.widetech.cartapp.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.widetech.cartapp.entities.TransactionDetailEntity;

@Repository
public interface TransactionDetailRepo extends JpaRepository<TransactionDetailEntity, Integer>, JpaSpecificationExecutor<TransactionDetailEntity>{

} 
