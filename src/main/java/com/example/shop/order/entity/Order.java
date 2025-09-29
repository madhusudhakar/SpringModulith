package com.example.shop.order.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "orders") // plural avoids reserved keyword

public class Order{

    @Id
    @GeneratedValue
    private UUID id;

    private String sku;
    private int quantity;

    protected Order() {}

    public Order(String sku, int quantity) {
        this.sku = sku;
        this.quantity = quantity;
    }

    public UUID getId() { return id; }
    public String getSku() { return sku; }
    public int getQuantity() { return quantity; }
}
