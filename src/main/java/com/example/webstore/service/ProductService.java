package com.example.webstore.service;


import com.example.webstore.entity.Product;
import com.example.webstore.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProductService  {

    @Autowired
    ProductRepository productRepository;

    @Value("${upload.path}")
    public String uploadPath;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public Product getProductsByID(Long id) {
        return productRepository.getOne(id);
    }

    public List<Product> search(String keyword) {
        return productRepository.searchProducts(keyword);
    }

    public List<Product> showPhones() {
        return productRepository.showPhones();
    }

    public List<Product> showComputers() {
        return productRepository.showComputers();
    }

    public List<Product> showTV() {
        return productRepository.showTV();
    }

    public List<Product> showAccessories() {
        return productRepository.showAccessories();
    }

    public List<Product> showAppliances() {
        return productRepository.showAppliances();
    }

    public void addFile(@ModelAttribute("products") Product product, @RequestParam("file") MultipartFile file) throws IOException {
        if (file != null) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFileName));
            product.setFileName(resultFileName);
        }
    }
}
