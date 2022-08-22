package com.example.bookstoreonline.service;

import com.example.bookstoreonline.dto.UploadBookDTO;
import com.example.bookstoreonline.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
public interface IBookService {
    Page<Book> getAllBooks(int pageNum);
    Book getBookById(Long bookId);
    Page<Book> getBooksByCategoryId(Long categoryId, int pageNum);
    Book addNewBook(UploadBookDTO uploadBookDTO, MultipartFile file);
}
