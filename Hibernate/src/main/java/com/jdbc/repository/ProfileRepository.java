package com.jdbc.repository;

import com.jdbc.model.StudentProfile;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;

@Repository
public class ProfileRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(StudentProfile profile) {
        entityManager.persist(profile);
    }
}
