package com.example.order;

import org.springframework.context.annotation.Configuration;
import org.springframework.modulith.Module;
import org.springframework.modulith.Dependency;

@Configuration
@Module(displayName = "order", exposedPackages = {"com.example.shop.order.dto"})
@Dependency(to = "customer")
@Dependency(to = "catalog")
public class OrderModule {
}
