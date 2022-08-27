package com.example.bookstoreonline.controller;

import com.example.bookstoreonline.dto.UploadBookDTO;
import com.example.bookstoreonline.service.IBookService;
import com.example.bookstoreonline.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/bookstore")
public class AdminController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/admin")
    public String showAdminPage() {
        return "/admin/admin";
    }

    @GetMapping("/admin/add-new-book")
    public String showAddNewBookPage(Model model) {
        model.addAttribute("uploadBookDTO", new UploadBookDTO());
        return "/admin/add-new-book";
    }

    @PostMapping("/admin/add-new-book")
    public String showAddNewBookPage(@RequestParam("image") MultipartFile image,
                                     @ModelAttribute("uploadBookDTO") UploadBookDTO uploadBookDTO,
                                     RedirectAttributes attributes) {
        bookService.addNewBook(uploadBookDTO, image);
        attributes.addAttribute("uploadSuccess", "Successfully uploaded new book!");
        return "redirect:/admin/add-new-book";
    }


}
