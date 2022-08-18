package com.example.bookstoreonline.service;

import com.example.bookstoreonline.model.Book;
import org.springframework.data.domain.Page;
import java.util.List;
public interface IBookService {
    Page<Book> getAllBooks(int pageNum);
    Book getBookById(Long bookId);
    Book addNewBook(Book book);
}
