package com.example.bookstoreonline.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;
    @Column(name = "book_name")
    private String name;
    @Column(name = "book_about")
    private String about;
    @Column(name = "book_language")
    private String language;
    @ElementCollection
    private List<String> genres;
    @Column(name = "book_author")
    private String author;
    @Column(name = "book_publisher")
    private String publisher;
    @Column(name = "book_publish_date")
    private LocalDateTime publishDate;
    @Column(name = "book_quantity")
    private Integer quantity;
    @Column(name = "book_price")
    private Double price;
    @Column(name = "book_image")
    private String image;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Book book = (Book) o;
        return id != null && Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
