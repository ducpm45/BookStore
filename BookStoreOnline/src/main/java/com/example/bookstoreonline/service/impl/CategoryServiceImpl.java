package com.example.bookstoreonline.service.impl;

import com.example.bookstoreonline.exception.ResourceNotFoundException;
import com.example.bookstoreonline.model.Category;
import com.example.bookstoreonline.repository.CategoryRepository;
import com.example.bookstoreonline.service.ICategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        log.info("List category: {}", categories);
        if(categories.isEmpty()) {
            throw new ResourceNotFoundException("Could not found category!");
        }
        return categories;
    }
}
