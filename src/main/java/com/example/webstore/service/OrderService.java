package com.example.webstore.service;

import com.example.webstore.entity.Orders;
import com.example.webstore.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Orders> getOrders() {
        return orderRepository.findAll();
    }

    public Orders getOrderById(Long id) {
        return orderRepository.getOne(id);
    }

    public boolean orderIsEmpty(Long id) {
        return orderRepository.existsById(id);
    }

    public void save(Orders orders) {
        orderRepository.save(orders);
    }

    public void delete(Orders orders) {
        orderRepository.delete(orders);
    }

    public Orders getOrdersByProductId(Long id) {
        return orderRepository.findOrdersByProductId(id);
    }

    public Integer getSumPrice() {
        return orderRepository.getSum();
    }
}
