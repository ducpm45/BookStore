package com.example.bookstoreonline.controller;

import com.example.bookstoreonline.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GeneralController {
    @Autowired
    private ICategoryService categoryService;
    @ModelAttribute
    public void populateModel(Model model) {
        model.addAttribute("categoryList", categoryService.getAllCategories());
    }
}
