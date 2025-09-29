package com.example.shop.common;

import java.util.UUID;

public record OrderPlacedEvent(UUID orderId, String sku, int quantity) {}

