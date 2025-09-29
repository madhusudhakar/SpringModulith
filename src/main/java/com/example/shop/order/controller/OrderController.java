package com.example.shop.order.controller;

import com.example.shop.common.OrderRequest;
import com.example.shop.order.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> placeOrder(@RequestBody OrderRequest req) {
        service.placeOrder(req);
        return ResponseEntity.accepted().build();
    }
}
