package com.widetech.cartapp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.widetech.cartapp.entities.TransactionEntity;

@Repository
public interface TransactionRepo extends JpaRepository<TransactionEntity, Integer>, JpaSpecificationExecutor<TransactionEntity>{

} 
