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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
@Controller
@Slf4j
public class MainController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/")
    public String showHomePage(Model model, @RequestParam(value = "userInput", required = false) String userInput) {
        model.addAttribute("title", "Trang chủ");
        if(null == userInput || userInput.trim().equals("")) {
            return showPage(model, 1, null);
        }
        return showPage(model, 1, userInput);
    }
    @GetMapping("/page/{pageNum}")
    public String showPage(Model model,
                                   @PathVariable(name = "pageNum") int pageNum,
                           String userInput) {
        model.addAttribute("title", "Trang chủ");
        if(null == userInput) {
            Page<Book> page = bookService.getAllBooks(pageNum);
            List<BookDTO> bookDTOList = new ArrayList<>();
//            page.getContent().forEach(bookDTO -> log.info(String.valueOf(bookDTO)));
            page.getContent().forEach(book -> bookDTOList.add(BookDTO.Mapper.mapFromBookEntity(book)));

            model.addAttribute("currentPage", pageNum);
            model.addAttribute("totalPages", page.getTotalPages());
            model.addAttribute("bookDTOList", bookDTOList);
        } else {
            if(null == bookService.searchAllBooksByName(pageNum, userInput.trim())) {
                model.addAttribute("searchByUserInputNoResult", "Không tìm thấy kết quả phù hợp");
            } else {
                Page<Book> pageSearchResult = bookService.searchAllBooksByName(pageNum, userInput.trim());
                List<BookDTO> bookDTOListSearchResult = new ArrayList<>();
                pageSearchResult.getContent().forEach(book -> bookDTOListSearchResult.add(BookDTO.Mapper.mapFromBookEntity(book)));
                model.addAttribute("currentPage", pageNum);
                model.addAttribute("totalPages", pageSearchResult.getTotalPages());
                model.addAttribute("bookDTOListSearchResult", bookDTOListSearchResult);
            }
        }
        return "index";
    }
    @GetMapping("/book-detail/{bookId}")
    public String showBookDetailPage(Model model, @PathVariable(name = "bookId") Long bookId) {
        Book book = bookService.getBookById(bookId);
        BookDTO bookDTO = BookDTO.Mapper.mapFromBookEntity(book);
        model.addAttribute("tittle", bookDTO.getName());
        model.addAttribute("bookDTO", bookDTO);
        return "book-detail";
    }

    @GetMapping("/category/{categoryId}")
    public String viewCategoryBookpage(Model model, @PathVariable(name = "categoryId") Long categoryId) {
        return showCategoryBookPage(model, categoryId, 1);
    }

    @GetMapping("/category/{categoryId}/{pageNum}")
    public String showCategoryBookPage(Model model, @PathVariable(name = "categoryId") Long categoryId,
                                       @PathVariable(name = "pageNum") int pageNum) {
        Category category = categoryService.getCategoryById(categoryId);
        Page<Book> categoryBookPage = bookService.getBooksByCategoryId(categoryId, pageNum);
        List<Book> categoryBookList = categoryBookPage.getContent();
        model.addAttribute("tittle", String.format("Sách %s", category.getCategoryName()));
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", categoryBookPage.getTotalPages());
        model.addAttribute("categoryBookList", categoryBookList);
        return "category-book";
    }
    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }
}
