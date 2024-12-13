package com.widetech.cartapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.widetech.cartapp.entities.TransactionEntity;
import com.widetech.cartapp.entities.TransactionInfoEntity;
import com.widetech.cartapp.models.TransactionModel;
import com.widetech.cartapp.models.ResponseModel;
import com.widetech.cartapp.services.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/get")
    public ResponseEntity<ResponseModel> getAllTransactionsController(){
        try{
            List<TransactionInfoEntity> transactions = transactionService.getAll();

            ResponseModel response = new ResponseModel();
            response.setMsg("Request success!");
            response.setData(transactions);

            return ResponseEntity.ok(response);
        }
        catch(Exception e){
            ResponseModel response = new ResponseModel();
            response.setMsg("Sorry there is a failure on our server.");

            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/addNewTransaction")
    public ResponseEntity<ResponseModel> addController(){
        try {
            TransactionEntity transaction = transactionService.add();

            ResponseModel response = new ResponseModel();
            response.setMsg("Request Successfully");
            response.setData(transaction);
            return ResponseEntity.ok(response);
        }
        catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMsg("Sorry, there is a failure on our server. " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    }
}
