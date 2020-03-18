package com.example.webstore.controller;

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

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        productService.delete(id);
        return "redirect:/change";
    }

    @RequestMapping(value = "edit/{id}")
    public String getUpdatePage(@PathVariable("id") Long id, Model model) {
        Product product = productService.getProductsByID(id);
        model.addAttribute("product", product);
        return "edit";
    }


}
