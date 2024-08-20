package com.samsung.phanvantiendung.services;

import com.samsung.phanvantiendung.repositories.OrderRepository;
import com.samsung.phanvantiendung.repositories.ProductRepository;
import com.samsung.phanvantiendung.repositories.models.entities.Order;
import com.samsung.phanvantiendung.repositories.models.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void AddOrder(Order order) {
        orderRepository.save(order);
    }

    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
