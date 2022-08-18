package com.example.bookstoreonline.service.impl;

import com.example.bookstoreonline.exception.ResourceNotFoundException;
import com.example.bookstoreonline.model.Book;
import com.example.bookstoreonline.repository.BookRepository;
import com.example.bookstoreonline.service.IBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class BookServiceImpl implements IBookService {
    @Value("${page.size}")
    private int pageSize;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Page<Book> getAllBooks(int pageNum) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<Book> page = bookRepository.findAll(pageable);
        if (!page.hasContent()) {
            throw new ResourceNotFoundException("Could not found book!");
        }
        return page;
    }

    @Override
    public Book getBookById(Long bookId) {
        Optional<Book> bookOpt = bookRepository.findById(bookId);
        if (!bookOpt.isPresent()) {
            throw new ResourceNotFoundException(String.format("Could not found book with id %s", bookId));
        }
        log.info("Book with id {}: {}", bookId, bookOpt.get());
        return bookOpt.get();
    }

    @Override
    public Book addNewBook(Book book) {
        return null;
    }
}
