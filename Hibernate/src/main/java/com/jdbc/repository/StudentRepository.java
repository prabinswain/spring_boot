package com.jdbc.repository;

import com.jdbc.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 * JPA - Hibernate */

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Transactional
    public Student findById(Integer id) {

        return entityManager.find(Student.class, id);
    }

    @Transactional
    public void deleteStudent(Student student) {
        entityManager.remove(student);
    }

    @Transactional
    public List<Student> findAllStudent() {

        return entityManager.createQuery("" +
                        "SELECT s from Student s",
                Student.class).getResultList();
    }

    @Transactional
    public void updateStudent(Student student, String id) {
        Student student1 = entityManager.find(Student.class, id);
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastname());
        student1.setEmail(student.getEmail());
        student1.setAge(student.getAge());

    }
}
