package com.example.bookstoreonline.service;

import com.example.bookstoreonline.model.Book;
import org.springframework.data.domain.Page;
import java.util.List;
public interface IBookService {
    Page<Book> getAllNewBooks();
    Book addBook(Book books);

}
