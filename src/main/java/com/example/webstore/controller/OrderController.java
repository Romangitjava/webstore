package com.example.webstore.controller;

import com.example.webstore.entity.Orders;
import com.example.webstore.service.OrderService;
import com.example.webstore.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderController {

    private final ProductService productService;
    private final OrderService orderService;

    public OrderController(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    @RequestMapping("/cart")
    public String getCart(Model model, Integer sumPrice) {
        model.addAttribute("orders", orderService.getOrders());
        model.addAttribute("sumPrice", orderService.getSumPrice());

        return "cart";
    }

   @RequestMapping(value = "addToOrder/{id}", method = RequestMethod.POST)
    public String addOrder(@PathVariable("id") Long id) {
           Orders currentOrder = new Orders();
           if (orderService.getOrdersByProductId(id) != null) {
               currentOrder = orderService.getOrdersByProductId(id);
               currentOrder.setQuantity(currentOrder.getQuantity() + 1);
               currentOrder.setOrderPrice(currentOrder.getProduct().getPrice()*currentOrder.getQuantity());
           }
           else {
               currentOrder.setProduct(productService.getProductsByID(id));
               currentOrder.setQuantity(1);
               currentOrder.setOrderPrice(currentOrder.getProduct().getPrice());

           }
           orderService.save(currentOrder);
           return "redirect:/cart";
   }

   @RequestMapping(value = "/deleteOrder/{id}", method = RequestMethod.GET)
    public String deleteOrder (@PathVariable("id") Orders orders) {
        orderService.delete(orders);
        return "redirect:/cart";
   }

   @RequestMapping(value = "/deleteAllOrders", method = RequestMethod.GET)
    public String deleteAllOrders() {
        orderService.deleteAllOrders();
        return "redirect:/cart";
   }

}
