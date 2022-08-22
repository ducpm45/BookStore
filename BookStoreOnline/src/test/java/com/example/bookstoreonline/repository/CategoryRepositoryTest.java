package com.example.bookstoreonline.repository;

import com.example.bookstoreonline.model.Category;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;
    @Test
    void getCategoryByCategoryName() {
        Category category = categoryRepository.getCategoryByCategoryName("Văn học");
        log.info("category: {}", category);
    }
}