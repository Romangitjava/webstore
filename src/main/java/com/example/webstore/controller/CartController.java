package com.example.webstore.controller;


import com.example.webstore.entity.Cart;
import com.example.webstore.service.CartService;
import com.example.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CartController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;



    @RequestMapping("/cart")
    public String getCart(Model model ) {
        model.addAttribute("cart", cartService.getCarts());
        return "cart";
    }

    @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
    public String addToCart(@ModelAttribute Cart cart) {
        cart.setQuantity(1);
        cart.setProducts(productService.getProducts());
        cartService.save(cart);
        return "redirect:/computers";
    }
}
