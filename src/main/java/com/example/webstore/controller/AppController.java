package com.example.webstore.controller;

import com.example.webstore.entity.Cart;
import com.example.webstore.entity.Product;
import com.example.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


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

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        productService.delete(id);
        return "redirect:/change";
    }
    @GetMapping("/edit")
    public String getEditPage(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "edit";
    }


    @RequestMapping(value = "/edit/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product)  {
        Product currentProduct = productService.getProductsByID(id);
        currentProduct.setManufacturer(product.getManufacturer());
        currentProduct.setModel(product.getModel());
        currentProduct.setPrice(product.getPrice());
        currentProduct.setAmount(product.getAmount());
        currentProduct.setDescription(product.getDescription());
        currentProduct.setProductTypes(product.getProductTypes());
        currentProduct.setFileName(product.getFileName());
        productService.save(currentProduct);
        return currentProduct;
    }

    @RequestMapping(value = "/addProducts", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("products") Product product,
                             @RequestParam("file") MultipartFile file)  throws IOException {
        if(file != null) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFileName));
            product.setFileName(resultFileName);
        }
        productService.save(product);
        return "redirect:/change";
    }
}
