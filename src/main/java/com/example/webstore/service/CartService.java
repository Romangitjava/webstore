package com.example.webstore.service;


import com.example.webstore.entity.Cart;
import com.example.webstore.entity.Product;
import com.example.webstore.repos.CartRepository;
import com.example.webstore.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;


    public List<Cart> getCarts() {
        return cartRepository.findAll();
    }

    public void save(Cart cart) {
        cartRepository.save(cart);
    }


   /* public void addToCart(Cart cart) {

    }*/
}
