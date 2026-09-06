package com.jdbc.service;

import com.jdbc.model.Student;
import com.jdbc.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    private final  StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Transactional
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    @Transactional
    public Student getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    @Transactional
    public void removeStudent(Integer id) {
       Student student =  studentRepository.findById(id);
        studentRepository.deleteStudent(student);
    }

    @Transactional
    public List<Student> getAllStudentBy() {
        return studentRepository.findAllStudent();
    }
    @Transactional
    public void updateStudent(Student student, String id) {
       studentRepository.updateStudent(student,id);
    }

    public List<Student> getAllStudentByPaging() {

        return null;
    }
}
