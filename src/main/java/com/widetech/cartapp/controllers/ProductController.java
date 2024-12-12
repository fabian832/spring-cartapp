package com.widetech.cartapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.widetech.cartapp.entities.ProductEntity;
import com.widetech.cartapp.models.ResponseModel;
import com.widetech.cartapp.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/get")
    public ResponseEntity<ResponseModel> getAllProductsController(){
        try{
            List<ProductEntity> products = productService.getAll();

            ResponseModel response = new ResponseModel();
            response.setMsg("Request success!");
            response.setData(products);

            return ResponseEntity.ok(response);
        }
        catch(Exception e){
            ResponseModel response = new ResponseModel();
            response.setMsg("Sorry there is a failure on our server.");

            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    }
}
