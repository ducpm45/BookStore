package com.example.bookstoreonline.repository;

import com.example.bookstoreonline.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> getBooksByPublishDateBetween(LocalDateTime fromPublishDate, LocalDateTime toPublishDate, Pageable pageable);
    Page<Book> getBooksByGenres(List<String> genres, Pageable pageable);

}
