package com.jdbc.repository;

import com.jdbc.model.Department;
import jakarta.persistence.Convert;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class DepartmentRepository {

    @PersistenceContext
    private EntityManager entityManager ;

    @Transactional
    public void save(Department department) {
        entityManager.persist(department);
    }
}
