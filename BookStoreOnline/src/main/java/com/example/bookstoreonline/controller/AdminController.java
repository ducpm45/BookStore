package com.example.bookstoreonline.controller;

import com.example.bookstoreonline.dto.BookDTO;
import com.example.bookstoreonline.dto.UploadBookDTO;
import com.example.bookstoreonline.model.Book;
import com.example.bookstoreonline.model.Category;
import com.example.bookstoreonline.repository.CategoryRepository;
import com.example.bookstoreonline.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private CategoryRepository categoryRepository;
    @GetMapping("/admin")
    public String showAdminPage(Model model) {
        model.addAttribute("title", "Quản trị BookStore");
        return "/admin/admin";
    }

    @GetMapping("/admin/all-books-manage")
    public String showAllBook(Model model) {
        model.addAttribute("title", "Quản lý sách");
        return showPage(model, 1);
    }
    @GetMapping("/admin/all-books-manage/{pageNum}")
    public String showPage(Model model,
                           @PathVariable(name = "pageNum") int pageNum) {
            Page<Book> page = bookService.getAllBooks(pageNum);
            List<BookDTO> bookDTOList = new ArrayList<>();
            page.getContent().forEach(book -> bookDTOList.add(BookDTO.Mapper.mapFromBookEntity(book)));
            model.addAttribute("currentPage", pageNum);
            model.addAttribute("totalPages", page.getTotalPages());
            model.addAttribute("bookDTOList", bookDTOList);

        return "/admin/book-manage";
    }
    @GetMapping("/admin/edit/{bookId}")
    public String showEditBookPage(Model model, @PathVariable(name = "bookId") Long bookId) {
        model.addAttribute("title", "Sửa thông tin sách");
        Book book = bookService.getBookById(bookId);
        model.addAttribute("bookDTO", BookDTO.Mapper.mapFromBookEntity(book));
        model.addAttribute("editBookDTO", new UploadBookDTO());
        return "/admin/edit-book";
    }

    @PostMapping("/admin/edit/{bookId}")
    public String editBook(Model model,
                           @PathVariable(name = "bookId") Long bookId,
                           @ModelAttribute("editBookDTO") UploadBookDTO editBookDTO) {
        if(bookService.editBook(editBookDTO, bookId)) {
            model.addAttribute("editSuccess", "Cập nhật thông tin sách thành công");
        } else {
            model.addAttribute("editFailed", "Cập nhật thông tin sách thất bại");
        }

        return "/admin/edit-book";
    }

    @GetMapping("/admin/add-new-book")
    public String showAddNewBookPage(Model model) {
        model.addAttribute("title", "Thêm sách mới");
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
