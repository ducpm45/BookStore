package com.example.bookstoreonline.controller;

import com.example.bookstoreonline.dto.UploadBookDTO;
import com.example.bookstoreonline.model.Category;
import com.example.bookstoreonline.service.IBookService;
import com.example.bookstoreonline.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
@RequestMapping("/bookstore/admin")
public class AdminController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showAdminPage() {
        return "/admin/admin";
    }

    @GetMapping("/add-new-book")
    public String showAddNewBookPage(Model model) {
        List<Category> categoryList = categoryService.getAllCategories();
        model.addAttribute("categoryList", categoryList);
        return "/admin/add-new-book";
    }
    @ModelAttribute(value = "uploadBookDTO")
    public UploadBookDTO newEntity()
    {
        return new UploadBookDTO();
    }

    @PostMapping("/add-new-book")
    public String showAddNewBookPage(@RequestParam("image") MultipartFile image,
                                     @ModelAttribute("uploadBookDTO") UploadBookDTO uploadBookDTO,
                                     RedirectAttributes attributes) {
        bookService.addNewBook(uploadBookDTO, image);
        attributes.addAttribute("uploadSuccess", "Successfully uploaded new book!");
        return "redirect:/admin/add-new-book";
    }


}
