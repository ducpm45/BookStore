package com.example.bookstoreonline.service.impl;

import com.example.bookstoreonline.exception.ResourceNotFoundException;
import com.example.bookstoreonline.model.Book;
import com.example.bookstoreonline.repository.BookRepository;
import com.example.bookstoreonline.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService {
    @Value("${page.size}")
    private int pageSize;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Page<Book> getAllBooks(int pageNum) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<Book> page = bookRepository.findAll(pageable);
        if(!page.hasContent()) {
            throw new ResourceNotFoundException("Could not found book!");
        }
        return page;
    }

    @Override
    public Book addNewBook(Book book) {
        return null;
    }
}
