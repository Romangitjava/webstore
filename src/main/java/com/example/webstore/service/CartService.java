package com.example.webstore.service;


import com.example.webstore.entity.Cart;
import com.example.webstore.repos.CartRepository;
import com.example.webstore.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<Cart> getCarts() {
        return cartRepository.findAll();
    }

    public void save(Cart cart) {
        cartRepository.save(cart);
    }


}