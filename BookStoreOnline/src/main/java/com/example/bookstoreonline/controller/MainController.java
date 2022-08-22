package com.example.bookstoreonline.controller;

import com.example.bookstoreonline.dto.BookDTO;
import com.example.bookstoreonline.model.Book;
import com.example.bookstoreonline.model.Category;
import com.example.bookstoreonline.service.IBookService;
import com.example.bookstoreonline.service.ICategoryService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class MainController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showHomePage(Model model) {
        return showPage(model, 1);
    }
    @GetMapping("/page/{pageNum}")
    public String showPage(Model model,
                           @PathVariable(name = "pageNum") int pageNum) {
        Page<Book> page = bookService.getAllBooks(pageNum);
        List<Book> bookList = page.getContent();
        List<Category> categoryList = categoryService.getAllCategories();

        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("bookList", bookList);
        return "index";
    }
    @GetMapping("/book-detail/{bookId}")
    public String showBookDetailPage(Model model, @PathVariable(name = "bookId") Long bookId) {
        Book book = bookService.getBookById(bookId);
        BookDTO bookDTO = BookDTO.Mapper.mapFromBookEntity(book);
        log.info("BookDTO: {}", bookDTO);
        List<Category> categoryList = categoryService.getAllCategories();
        model.addAttribute("bookDTO", bookDTO);
        model.addAttribute("categoryList", categoryList);
        return "/user/book-detail";
    }

    @GetMapping("/category-book/{categoryId}")
    public String viewCategoryBookpage(Model model, @PathVariable(name = "categoryId") Long categoryId) {
        return showCategoryBookPage(model, categoryId, 1);
    }

    @GetMapping("/category-book/{categoryId}/{pageNum}")
    public String showCategoryBookPage(Model model, @PathVariable(name = "categoryId") Long categoryId,
                                       @PathVariable(name = "pageNum") int pageNum) {
        Category category = categoryService.getCategoryById(categoryId);
        Page<Book> categoryBookPage = bookService.getBooksByCategoryId(categoryId, pageNum);
        List<Book> categoryBookList = categoryBookPage.getContent();
        List<Category> categoryList = categoryService.getAllCategories();

        model.addAttribute("categoryName", category.getCategoryName());
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", categoryBookPage.getTotalPages());
        model.addAttribute("categoryBookList", categoryBookList);
        model.addAttribute("categoryList", categoryList);
        return "/user/category-book";
    }
    
    @GetMapping("/cart")
    public String showCartPage(Model model) {
        List<Category> categoryList = categoryService.getAllCategories();
        model.addAttribute("categoryList", categoryList);

        return "/user/cart";
    }

    @GetMapping("/test")
    public String test(Model model) {
        return "test";
    }

}
