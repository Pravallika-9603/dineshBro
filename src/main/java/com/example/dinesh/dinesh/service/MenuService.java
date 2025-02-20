package com.example.dinesh.dinesh.service;

import com.example.dinesh.dinesh.model.Category;
import com.example.dinesh.dinesh.model.MenuItem;
import com.example.dinesh.dinesh.repository.CategoryRepository;
import com.example.dinesh.dinesh.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    private final MenuRepository menuRepository;
    private final CategoryRepository categoryRepository;

    public MenuService(MenuRepository menuRepository, CategoryRepository categoryRepository) {
        this.menuRepository = menuRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategoryItems() {
        return categoryRepository.findAll();
    }

    public List<MenuItem> getMenuItemsByCategoryName(String categoryName) {
        return menuRepository.findByCategoryName(categoryName);
    }

}
