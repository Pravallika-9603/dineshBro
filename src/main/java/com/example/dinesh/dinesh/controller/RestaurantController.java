package com.example.dinesh.dinesh.controller;

import com.example.dinesh.dinesh.model.Category;
import com.example.dinesh.dinesh.model.MenuItem;
import com.example.dinesh.dinesh.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class RestaurantController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/categoryitems")
    public List<Category> getMenuItems() {
        return menuService.getAllCategoryItems();
    }

    @GetMapping("/categories/{categoryName}/menuitems")
    public List<MenuItem> getMenuItemsByCategoryName(@PathVariable String categoryName) {
        return menuService.getMenuItemsByCategoryName(categoryName);
    }

}

