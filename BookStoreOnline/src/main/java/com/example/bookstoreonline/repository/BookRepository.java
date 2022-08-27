package com.example.bookstoreonline.repository;

import com.example.bookstoreonline.model.Book;
import com.example.bookstoreonline.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> findByCategory_Id(Long categoryId, Pageable pageable);
    Page<Book> findByNameContaining(String name, Pageable pageable);
}
