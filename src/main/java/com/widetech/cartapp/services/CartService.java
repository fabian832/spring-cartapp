package com.widetech.cartapp.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.widetech.cartapp.entities.CartDetailEntity;
import com.widetech.cartapp.entities.CartEntity;
import com.widetech.cartapp.entities.CartInfoEntity;
import com.widetech.cartapp.entities.ProductEntity;
import com.widetech.cartapp.globals.GlobalConstant;
import com.widetech.cartapp.models.CartDetailModel;
import com.widetech.cartapp.models.CartModel;
import com.widetech.cartapp.repos.CartDetailRepo;
import com.widetech.cartapp.repos.CartInfoRepo;
import com.widetech.cartapp.repos.CartRepo;
import com.widetech.cartapp.repos.ProductRepo;

@Service
public class CartService {
    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private CartDetailRepo cartDetailRepo;

    @Autowired
    private CartInfoRepo cartInfoRepo;

    @Autowired
    private ProductRepo productRepo;

    public List<CartDetailEntity> getAll() {
        List<CartDetailEntity> cartInfo = new ArrayList<>();
        cartDetailRepo.findAllCartInfo().forEach(cartInfo::add);

        return cartInfo;
    }

    public CartEntity add(CartModel cartModel) {
        CartEntity cart = new CartEntity();
        
        cart.setAddress(cartModel.getAddress());
        cart.setName(cartModel.getName());
        cart.setRecStatus(GlobalConstant.REC_STATUS_ACTIVE);
        cart.setCreatedDate(new Timestamp(System.currentTimeMillis()));

        return cartRepo.save(cart);
    }

    public CartDetailEntity findById(Integer id){
        return cartDetailRepo.findById(id).orElse(null);
    }

    public CartEntity findCartById(Integer id){
        return cartRepo.findById(id).orElse(null);
    }

    public CartDetailEntity addProduct(CartDetailModel cartDetailModel) {
        CartDetailEntity cartDetail = cartDetailRepo.findActivedProduct(cartDetailModel.getProductId(), cartDetailModel.getCartId());
        ProductEntity product = productRepo.findById(cartDetailModel.getProductId()).orElse(null);
        
        if(cartDetail != null){
            if(cartDetail.getQuantity() + cartDetailModel.getQuantity() > product.getStock()){
                cartDetail.setQuantity(product.getStock());
            }
            else{
                cartDetail.setQuantity(cartDetail.getQuantity() + cartDetailModel.getQuantity());
            }
            cartDetail.setUpdatedDate(new Timestamp(System.currentTimeMillis()));

            return cartDetailRepo.save(cartDetail);
        }

        cartDetail = new CartDetailEntity();
        cartDetail.setCartId(cartDetailModel.getCartId());
        cartDetail.setProductId(cartDetailModel.getProductId());
        cartDetail.setQuantity(cartDetailModel.getQuantity());
        cartDetail.setRecStatus(GlobalConstant.REC_STATUS_ACTIVE);
        cartDetail.setCreatedDate(new Timestamp(System.currentTimeMillis()));

        return cartDetailRepo.save(cartDetail);
    }

    public CartEntity editCart(CartModel cartModel) {
        CartEntity cart = findCartById(cartModel.getId());

        cart.setAddress(cartModel.getAddress());
        cart.setName(cartModel.getName());
        cart.setRecStatus(GlobalConstant.REC_STATUS_ACTIVE);
        cart.setUpdatedDate(new Timestamp(System.currentTimeMillis()));

        return cartRepo.save(cart);
    }

    public CartEntity removeCart(CartModel cartModel) {
        CartEntity cart = findCartById(cartModel.getId());
        cart.setRecStatus(GlobalConstant.REC_STATUS_NON_ACTIVE);
        cart.setDeletedDate(new Timestamp(System.currentTimeMillis()));

        return cartRepo.save(cart);
    }


    public CartDetailEntity editProduct(CartDetailModel cartDetailModel) {
        CartDetailEntity cartDetail = cartDetailRepo.findActivedProduct(cartDetailModel.getProductId(), cartDetailModel.getCartId());

        cartDetail.setProductId(cartDetailModel.getProductId());
        cartDetail.setQuantity(cartDetailModel.getQuantity());
        cartDetail.setRecStatus(GlobalConstant.REC_STATUS_ACTIVE);
        cartDetail.setUpdatedDate(new Timestamp(System.currentTimeMillis()));

        return cartDetailRepo.save(cartDetail);
    }

    public CartDetailEntity removeProduct(CartDetailModel cartDetailModel) {
        CartDetailEntity cartDetail = cartDetailRepo.findActivedProduct(cartDetailModel.getProductId(), cartDetailModel.getCartId());

        cartDetail.setQuantity(0);
        cartDetail.setRecStatus(GlobalConstant.REC_STATUS_NON_ACTIVE);
        cartDetail.setDeletedDate(new Timestamp(System.currentTimeMillis()));

        return cartDetailRepo.save(cartDetail);
    }
}
