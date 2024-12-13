package com.widetech.cartapp.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.widetech.cartapp.entities.TransactionDetailEntity;
import com.widetech.cartapp.entities.TransactionEntity;
import com.widetech.cartapp.entities.TransactionInfoEntity;
import com.widetech.cartapp.entities.CartDetailEntity;
import com.widetech.cartapp.entities.CartEntity;
import com.widetech.cartapp.entities.CartInfoEntity;
import com.widetech.cartapp.entities.ProductEntity;
import com.widetech.cartapp.globals.GlobalConstant;
import com.widetech.cartapp.models.TransactionModel;
import com.widetech.cartapp.repos.CartDetailRepo;
import com.widetech.cartapp.repos.CartInfoRepo;
import com.widetech.cartapp.repos.CartRepo;
import com.widetech.cartapp.repos.ProductRepo;
import com.widetech.cartapp.repos.TransactionDetailRepo;
import com.widetech.cartapp.repos.TransactionInfoRepo;
import com.widetech.cartapp.repos.TransactionRepo;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepo transactionRepo;

    @Autowired
    private TransactionDetailRepo transactionDetailRepo;

    @Autowired
    private TransactionInfoRepo transactionInfoRepo;

    @Autowired
    private CartInfoRepo cartInfoRepo;

    @Autowired
    private CartDetailRepo cartDetailRepo;

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private ProductRepo productRepo;

    public List<TransactionInfoEntity> getAll() {
        List<TransactionInfoEntity> transactionInfo = new ArrayList<>();
        transactionInfoRepo.findAll().forEach(transactionInfo::add);

        return transactionInfo;
    }

    public TransactionEntity add() {
        TransactionEntity transaction = new TransactionEntity();

        List<CartInfoEntity> cartInfo = new ArrayList<>();
        cartInfoRepo.findAll().forEach(cartInfo::add);

        CartEntity cart = cartRepo.findById(1).orElse(null);

        transaction.setAddress(cart.getAddress());
        transaction.setName(cart.getName());

        transaction.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        transactionRepo.save(transaction);


        Integer transactionId = transaction.getId();

        for (CartInfoEntity product : cartInfo) {
            TransactionDetailEntity transactionDetail = new TransactionDetailEntity();
            transactionDetail.setTransactionId(transactionId);
            transactionDetail.setProductId(product.getProductId());
            transactionDetail.setQuantity(product.getQuantity());
            transactionDetail.setRecStatus(GlobalConstant.REC_STATUS_ACTIVE);
            transactionDetail.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            transactionDetailRepo.save(transactionDetail);

            ProductEntity productMain = productRepo.findById(product.getProductId()).orElse(null);
            productMain.setStock(productMain.getStock() - product.getQuantity());
            
            if(productMain.getStock() == 0){
                productMain.setRecStatus(GlobalConstant.REC_STATUS_NON_ACTIVE);
            }
            productRepo.save(productMain);
        }

        cartDetailRepo.deleteAll(); 
        // cartRepo.delete(cart); 
        return transaction;
    }
}
