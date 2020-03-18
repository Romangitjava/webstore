package com.example.webstore.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productTypes;
    private String manufacturer;
    private String model;
    private int price;
    private int amount;
    private String fileName;
    private String description;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Orders> orders;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(String productTypes) {
        this.productTypes = productTypes;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Orders> getOrder() {
        return orders;
    }

    public void setOrder(List<Orders> orders) {
        this.orders = orders;
    }
}
