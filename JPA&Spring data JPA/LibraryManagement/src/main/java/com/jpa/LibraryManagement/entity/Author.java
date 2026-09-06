package com.jpa.LibraryManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "author")
@Getter
@Setter
@NoArgsConstructor
public class Author {

//
//    public Author(String name, String bio) {
//        this.name = name;
//        this.bio = bio;
//    }

    public Author(UUID authorId, String name, String bio) {
        this.authorId = authorId;
        this.name = name;
        this.bio = bio;
    }

    public Author(String name, String bio) {
        this.name = name;
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", name='" + name + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }

    @Id
    @Column(name = "author_id",nullable = false)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "author_seq")
//    @SequenceGenerator(name = "author_seq" , sequenceName = "author_seq", allocationSize = 51)
    @GeneratedValue(strategy = GenerationType.AUTO )
    private UUID authorId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "bio", nullable = false)
    private String bio;

}
