package com.jpa.LibraryManagement.dao.impl;

import com.jpa.LibraryManagement.dao.LibraryDao;
import com.jpa.LibraryManagement.entity.Author;
import jakarta.persistence.EntityManager;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @Repository - helps in componenent scannig and Translates JDBC exceptions into checked exception
 *
 */

@Repository

public class LibraryDaoImpl implements LibraryDao {

    private final EntityManager entityManager;

    @Autowired
    public LibraryDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional // Handles transaction in a proxy and commit and rollback
    public void save(Author author) {
        entityManager.persist(author);
    }

    @Override
    public Author findById(UUID authorId) {
       return entityManager.find( Author.class, authorId);
    }


}
