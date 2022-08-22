package com.example.bookstoreonline.dto;

import com.example.bookstoreonline.model.Book;
import com.example.bookstoreonline.model.Category;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class UploadBookDTO {
    private String name;
    private String about;
    private String language;
    private String category;
    private String author;
    private String publisher;
    private String publishDate;
    private Integer quantity;
    private Double price;
    private Double discount;
}
