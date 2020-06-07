package com.example.webstore.service;

import com.example.webstore.entity.Orders;
import com.example.webstore.repos.OrderRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Orders> getOrders() {
        return orderRepository.findAll();
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

    public void deleteAllOrders() {
        orderRepository.deleteAll();
    }
}
