package com.example.bookstoreonline.service.impl;

import com.example.bookstoreonline.exception.ResourceNotFoundException;
import com.example.bookstoreonline.model.Book;
import com.example.bookstoreonline.repository.BookRepository;
import com.example.bookstoreonline.service.IBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class BookServiceImpl implements IBookService {
    @Autowired
    private BookRepository bookRepository;
    @Value("${genres.page.size}")
    private int genresPageSize;
    @Value("${new.book.page.size}")
    private int newBookPageSize;
    @Value("${page.number}")
    private int pageNumber;

    @Override
    public Page<Book> getAllNewBooks() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneYearBefore = now.minusYears(1);
        Page<Book> pageNewBook = bookRepository.getBooksByPublishDateBetween(oneYearBefore, now,
                PageRequest.of(pageNumber, newBookPageSize));
        if(!pageNewBook.hasContent()) {
            throw new ResourceNotFoundException("Does not exist any book in resource!");
        }
        log.info("Load new book: {} with pageNumber {}, pageSize {}", pageNewBook, pageNumber, newBookPageSize);
        return pageNewBook;
    }

    @Override
    public Book addBook(Book books) {
        return bookRepository.save(books);
    }
}
