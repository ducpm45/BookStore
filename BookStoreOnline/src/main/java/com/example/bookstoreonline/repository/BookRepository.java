package com.example.bookstoreonline.repository;

import com.example.bookstoreonline.model.Book;
import com.example.bookstoreonline.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> findByCategory_Id(Long categoryId, Pageable pageable);
    Page<Book> findByNameContaining(String name, Pageable pageable);
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE FROM tbl_books WHERE tbl_books.book_id IN(?1)")
    void deleteManyBook(List<Long> configId);
}
