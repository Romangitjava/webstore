package com.example.webstore.controller;

import com.example.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search (@RequestParam String keyword, Model model){
        model.addAttribute("products", productService.search(keyword));
        return "main";
    }

    @RequestMapping(value = "/phones", method = RequestMethod.GET)
    public String showPhone (Model model) {
        model.addAttribute("products", productService.showPhones());
        return "phones";
    }

    @RequestMapping(value = "/computers", method = RequestMethod.GET)
    public String showComputers (Model model) {
        model.addAttribute("products", productService.showComputers());
        return "computers";
    }

    @RequestMapping(value = "/TV", method = RequestMethod.GET)
    public String showTV (Model model) {
        model.addAttribute("products", productService.showTV());
        return "TV";
    }

    @RequestMapping(value = "/appliances", method = RequestMethod.GET)
    public String showAppliances (Model model) {
        model.addAttribute("products", productService.showAppliances());
        return "appliances";
    }

    @RequestMapping(value = "/accessories", method = RequestMethod.GET)
    public String showAccessories (Model model) {
        model.addAttribute("products", productService.showAccessories());
        return "accessories";
    }
}
