package com.example.webstore.controller;

import com.example.webstore.entity.Cart;
import com.example.webstore.entity.Orders;
import com.example.webstore.repos.ProductRepository;
import com.example.webstore.service.CartService;
import com.example.webstore.service.OrderService;
import com.example.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/cart")
    public String getCart(Model model ) {
        model.addAttribute("orders", orderService.getOrders() );
        return "cart";
    }

   @RequestMapping(value = "addToOrder/{id}", method = RequestMethod.POST)
    public String addOrder(@PathVariable("id") Long id, Orders orders) {
        if (!orderService.orderIsEmpty(id)) {
            orders = new Orders();
            Cart cart = new Cart();
            orders.setProduct(productService.getProductsByID(id));
            orders.setQuantity(2);
            orders.setCart(cart);
            cartService.save(cart);
        }
        else {
            orders.setQuantity(orders.getQuantity() + 1);
        }
       orderService.save(orders);
       return "redirect:/cart";

   }

   @RequestMapping(value = "/deleteOrder/{id}", method = RequestMethod.POST)
    public String deleteOrder (@PathVariable("id") Orders orders) {
        orderService.delete(orders);
        return "redirect:/cart";
   }
}
