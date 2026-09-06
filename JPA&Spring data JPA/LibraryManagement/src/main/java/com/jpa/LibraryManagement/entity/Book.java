package com.jpa.LibraryManagement.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "books")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "published_date")
    private LocalDate publishedDate;

    // Foreign Key IDs (No Relationships)
    @Column(name = "author_id", nullable = false)
    private Long authorId;

    @Column(name = "publisher_id", nullable = false)
    private Long publisherId;

    @Column(name = "category_id", nullable = false)
    private Long categoryId;
}
