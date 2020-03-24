package com.example.webstore.controller;

import com.example.webstore.entity.Product;
import com.example.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Controller
public class AppController {

    @Autowired
    private ProductService productService;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/main")
    public String main(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "main";
    }

    @GetMapping("/change")
    public String changeTable(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "change";
    }

    @RequestMapping(value = "/addProducts", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("products") Product product,
                             @RequestParam("file") MultipartFile file)  throws IOException {
        productService.addFile(product, file);
        productService.save(product);
        return "redirect:/change";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        productService.delete(id);
        return "redirect:/change";
    }

    @RequestMapping(value = "edit/{id}")
    public String getEditPage(@PathVariable("id") Long id, Model model) {
        Product product = productService.getProductsByID(id);
        model.addAttribute("product", product);
        return "edit";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public String update(@ModelAttribute("product") Product product,
                         @RequestParam("file") MultipartFile file)  throws IOException {
        productService.addFile(product, file);
        productService.save(product);
        return "redirect:/change";
    }
}
