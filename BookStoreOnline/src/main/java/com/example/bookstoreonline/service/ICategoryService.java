package com.example.bookstoreonline.service;

import com.example.bookstoreonline.model.Category;
import java.util.List;
public interface ICategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long categoryId);
}
