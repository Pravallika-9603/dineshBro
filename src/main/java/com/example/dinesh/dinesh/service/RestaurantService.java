package com.example.dinesh.dinesh.service;

import com.example.dinesh.dinesh.model.Category;
import com.example.dinesh.dinesh.model.MenuItem;
import com.example.dinesh.dinesh.model.Order;
import com.example.dinesh.dinesh.repository.CategoryRepository;
import com.example.dinesh.dinesh.repository.MenuRepository;
import com.example.dinesh.dinesh.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RestaurantService {

    private final MenuRepository menuRepository;
    private final CategoryRepository categoryRepository;
    private final OrderRepository orderRepository;

    public RestaurantService(MenuRepository menuRepository, CategoryRepository categoryRepository, OrderRepository orderRepository) {
        this.menuRepository = menuRepository;
        this.categoryRepository = categoryRepository;
        this.orderRepository=orderRepository;
    }

    public List<Category> getAllCategoryItems() {
        return categoryRepository.findAll();
    }

    public List<MenuItem> getMenuItemsByCategoryName(String categoryName) {
        return menuRepository.findByCategoryName(categoryName);
    }

    public Order createOrder(List<Long> menuItemIds) {
        List<MenuItem> menuItems = menuRepository.findAllById(menuItemIds);

        // Calculate total amount
        double totalAmount = menuItems.stream().mapToDouble(MenuItem::getPrice).sum();

        Order order = new Order();
        order.setMenuItems(menuItems);
        order.setTotalAmount(totalAmount);

        return orderRepository.save(order);
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

}
