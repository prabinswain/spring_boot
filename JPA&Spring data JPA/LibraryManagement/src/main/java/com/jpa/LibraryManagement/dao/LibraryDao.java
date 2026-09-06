package com.jpa.LibraryManagement.dao;

import com.jpa.LibraryManagement.entity.Author;

import java.util.UUID;

public interface LibraryDao {

   void save(Author author);
    Author findById(UUID authorId);
}
