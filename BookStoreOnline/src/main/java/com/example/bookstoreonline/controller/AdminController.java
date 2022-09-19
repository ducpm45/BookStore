package com.example.bookstoreonline.controller;

import com.example.bookstoreonline.dto.BookDTO;
import com.example.bookstoreonline.dto.UploadBookDTO;
import com.example.bookstoreonline.model.Book;
import com.example.bookstoreonline.repository.CategoryRepository;
import com.example.bookstoreonline.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
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
//            List<Long> deleteBookIdList = new ArrayList<>();
            page.getContent().forEach(book -> bookDTOList.add(BookDTO.Mapper.mapFromBookEntity(book)));
            model.addAttribute("currentPage", pageNum);
            model.addAttribute("totalPages", page.getTotalPages());
            model.addAttribute("bookDTOList", bookDTOList);
//            model.addAttribute("deleteBookIdList", deleteBookIdList);
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
    public String editBook(@PathVariable(name = "bookId") Long bookId,
                           @ModelAttribute("editBookDTO") UploadBookDTO editBookDTO) {
       bookService.editBook(editBookDTO, bookId);
        return "/admin/edit-book";
    }
    @GetMapping("/admin/delete/{bookId}")
    public String deleteOneBook(Model model, @PathVariable(name = "bookId") Long bookId) {
        bookService.deleteBookById(bookId);
        if(bookService.getBookById(bookId) == null) {
            model.addAttribute("deleteSuccess", "Xóa sách thành công");
        } else {
            model.addAttribute("deleteFailed", "Xóa sách thất bại");
        }
        return "/admin/admin";
    }

    @GetMapping("/admin/delete-books-checked")
    public String deleteManyBook(Model model, @RequestParam(name = "bookId") Long[] bookIdArr) {
        bookService.deleteManyBook(bookIdArr);
        for (Long bookId : bookIdArr) {
            if (bookService.getBookById(bookId) != null) {
                model.addAttribute("deleteManyBookFailed", "Xóa thất bại");
            }
        }
        model.addAttribute("deleteManyBookSuccess", "Xóa thành công");
        return "/admin/admin";
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
