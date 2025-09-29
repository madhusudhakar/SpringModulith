package com.example.shop.inventory.service;

import com.example.shop.common.OrderPlacedEvent;
import com.example.shop.inventory.repository.InventoryRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService {

    private final InventoryRepository repo;

    public InventoryService(InventoryRepository repo) {
        this.repo = repo;
    }

    @EventListener
    @Transactional
    public void on(OrderPlacedEvent event) {
        repo.findById(event.sku()).ifPresent(inv -> {
            inv.reduceStock(event.quantity());
            repo.save(inv);
        });
    }
}
