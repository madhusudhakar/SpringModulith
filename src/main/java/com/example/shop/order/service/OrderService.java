package com.example.shop.order.service;

import com.example.shop.common.OrderPlacedEvent;
import com.example.shop.common.OrderRequest;
import com.example.shop.order.entity.Order;
import com.example.shop.order.repository.OrderRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private final OrderRepository repo;
    private final ApplicationEventPublisher events;

    public OrderService(OrderRepository repo, ApplicationEventPublisher events) {
        this.repo = repo;
        this.events = events;
    }

    @Transactional
    public void placeOrder(OrderRequest req) {
        Order order = new Order(req.sku(), req.quantity());
        repo.save(order);
        events.publishEvent(new OrderPlacedEvent(order.getId(), order.getSku(), order.getQuantity()));
    }
}
