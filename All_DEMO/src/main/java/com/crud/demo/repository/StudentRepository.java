package com.crud.demo.repository;

import com.crud.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

//@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    Optional<Student> findByIdAndDeletedIsFalse(Long id);

    //    @Query("select * from student where deleted = false")
    List<Student> findAllByDeletedIsFalse();

    boolean existsByEmail(String email);
}
