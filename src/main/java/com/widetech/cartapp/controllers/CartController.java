package com.widetech.cartapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.widetech.cartapp.entities.CartDetailEntity;
import com.widetech.cartapp.entities.CartEntity;
import com.widetech.cartapp.entities.CartInfoEntity;
import com.widetech.cartapp.models.CartDetailModel;
import com.widetech.cartapp.models.CartModel;
import com.widetech.cartapp.models.ResponseModel;
import com.widetech.cartapp.services.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/get")
    public ResponseEntity<ResponseModel> getAllCartsController(){
        try{
            List<CartInfoEntity> carts = cartService.getAll();

            ResponseModel response = new ResponseModel();
            response.setMsg("Request success!");
            response.setData(carts);

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
    @PostMapping(value="/addNewCart")
    public ResponseEntity<ResponseModel> addController(@RequestBody CartModel cartModel){
        try {
            CartEntity cart = cartService.add(cartModel);

            ResponseModel response = new ResponseModel();
            response.setMsg("Request Successfully");
            response.setData(cart);
            return ResponseEntity.ok(response);
        }
        catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMsg("Sorry, there is a failure on our server. " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value="/addNewProductCart")
    public ResponseEntity<ResponseModel> addProductController(@RequestBody CartDetailModel cartDetailModel){
        try {
            CartDetailEntity cartDetail = cartService.addProduct(cartDetailModel);

            ResponseModel response = new ResponseModel();
            response.setMsg("Request Successfully");
            response.setData(cartDetail);
            return ResponseEntity.ok(response);
        }
        catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMsg("Sorry, there is a failure on our server. " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value="/editCart")
    public ResponseEntity<ResponseModel> editCartController(@RequestBody CartModel cartModel){
        try {
            CartEntity cart = cartService.editCart(cartModel);

            ResponseModel response = new ResponseModel();
            response.setMsg("Request Successfully");
            response.setData(cart);
            return ResponseEntity.ok(response);
        }
        catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMsg("Sorry, there is a failure on our server. " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value="/editProductCart")
    public ResponseEntity<ResponseModel> editProductController(@RequestBody CartDetailModel cartDetailModel){
        try {
            CartDetailEntity cartDetail = cartService.editProduct(cartDetailModel);

            ResponseModel response = new ResponseModel();
            response.setMsg("Request Successfully");
            response.setData(cartDetail);
            return ResponseEntity.ok(response);
        }
        catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMsg("Sorry, there is a failure on our server. " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value="/removeProductCart")
    public ResponseEntity<ResponseModel> removeProductController(@RequestBody CartDetailModel cartDetailModel){
        try {
            CartDetailEntity cartDetail = cartService.removeProduct(cartDetailModel);

            ResponseModel response = new ResponseModel();
            response.setMsg("Request Successfully");
            response.setData(cartDetail);
            return ResponseEntity.ok(response);
        }
        catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMsg("Sorry, there is a failure on our server. " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value="/removeCart")
    public ResponseEntity<ResponseModel> removeCartController(@RequestBody CartModel cartModel){
        try {
            CartEntity cart = cartService.removeCart(cartModel);

            ResponseModel response = new ResponseModel();
            response.setMsg("Request Successfully");
            response.setData(cart);
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
