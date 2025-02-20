package com.example.dinesh.dinesh.controller;

import com.example.dinesh.dinesh.model.Category;
import com.example.dinesh.dinesh.model.MenuItem;
import com.example.dinesh.dinesh.model.Order;
import com.example.dinesh.dinesh.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/categoryitems")
    public List<Category> getMenuItems() {
        return restaurantService.getAllCategoryItems();
    }

    @GetMapping("/categories/{categoryName}/menuitems")
    public List<MenuItem> getMenuItemsByCategoryName(@PathVariable String categoryName) {
        return restaurantService.getMenuItemsByCategoryName(categoryName);
    }

    @PostMapping("/create")
    public Order createOrder(@RequestBody List<Long> menuItemIds) {
        return restaurantService.createOrder(menuItemIds);
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable Long id) {
        return restaurantService.getOrderById(id);
    }

}

