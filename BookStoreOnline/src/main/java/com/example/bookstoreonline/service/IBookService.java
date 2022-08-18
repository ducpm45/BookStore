package com.example.bookstoreonline.service;

import com.example.bookstoreonline.model.Book;
import org.springframework.data.domain.Page;
import java.util.List;
public interface IBookService {
    Page<Book> getAllNewBooks(int pageNum);
    Book addBook(Book books);
}
