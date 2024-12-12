package com.widetech.cartapp.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.widetech.cartapp.entities.CartDetailEntity;
import com.widetech.cartapp.entities.CartEntity;
import com.widetech.cartapp.entities.CartInfoEntity;
import com.widetech.cartapp.exceptions.ClientException;
import com.widetech.cartapp.globals.GlobalConstant;
import com.widetech.cartapp.models.CartDetailModel;
import com.widetech.cartapp.models.CartModel;
import com.widetech.cartapp.repos.CartDetailRepo;
import com.widetech.cartapp.repos.CartInfoRepo;
import com.widetech.cartapp.repos.CartRepo;

@Service
public class CartService {
    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private CartDetailRepo cartDetailRepo;

    @Autowired
    private CartInfoRepo cartInfoRepo;

    public List<CartInfoEntity> getAll() {
        List<CartInfoEntity> cartInfo = new ArrayList<>();
        cartInfoRepo.findAllCartInfo().forEach(cartInfo::add);

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
        CartDetailEntity cartDetail = new CartDetailEntity();

        cartDetail.setId(cartDetailModel.getCartId());
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
