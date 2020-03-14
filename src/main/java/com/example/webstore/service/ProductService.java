package com.example.webstore.service;


import com.example.webstore.entity.Product;
import com.example.webstore.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

}
