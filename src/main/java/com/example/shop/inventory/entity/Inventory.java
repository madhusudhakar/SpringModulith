package com.example.shop.inventory.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Inventory {

    @Id
    private String sku;
    private int stock;

    protected Inventory() {}

    public Inventory(String sku, int stock) {
        this.sku = sku;
        this.stock = stock;
    }

    public String getSku() { return sku; }
    public int getStock() { return stock; }
    public void reduceStock(int qty) { this.stock -= qty; }
}
