package com.example.bookstoreonline.dto;

import com.example.bookstoreonline.model.Book;
import com.example.bookstoreonline.model.Category;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class BookDTO {
    private Long id;
    private String name;
    private String about;
    private String language;
    private Category category;
    private String author;
    private String publisher;
    private LocalDate publishDate;
    private Integer quantity;
    private Double price;
    private String image;
    private Double discount;
    private Double newPrice;

    public static class Mapper {
        public static BookDTO mapFromBookEntity(Book book) {
            return BookDTO.builder()
                    .id(book.getId())
                    .name(book.getName())
                    .about(book.getAbout())
                    .language(book.getLanguage())
                    .category(book.getCategory())
                    .author(book.getAuthor())
                    .publisher(book.getPublisher())
                    .publishDate(book.getPublishDate())
                    .quantity(book.getQuantity())
                    .price(book.getPrice())
                    .image(book.getImage())
                    .discount(book.getDiscount())
                    .newPrice(Math.floor(book.getPrice() - (book.getPrice() * book.getDiscount())))
                    .build();
        }
    }
}
