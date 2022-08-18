package com.example.bookstoreonline.controller;

import com.example.bookstoreonline.model.Book;
import com.example.bookstoreonline.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
@Controller
@RequestMapping("/bookstore")
public class MainController {
    @Autowired
    private IBookService bookService;

    @GetMapping("")
    public String showHomePage(Model model) {
        return showPage(model, 1);
    }
    @GetMapping("/page/{pageNum}")
    public String showPage(Model model,
                           @PathVariable(name = "pageNum") int pageNum) {
        Page<Book> page = bookService.getAllBooks(pageNum);
        List<Book> bookList = page.getContent();

        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("bookList", bookList);
        return "index";
    }

    @GetMapping("/test")
    public String test(Model model) {
        return "test";
    }
}
