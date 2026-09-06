package com.jdbc.service;

import com.jdbc.model.Student;
import com.jdbc.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final  StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public boolean createStudent(Student student) {
       return studentRepository.save(student);
    }

    public Student getStudentById(String id) {
        return studentRepository.findById(id);
    }

    public boolean removeStudent(String id) {
        return studentRepository.deleteStudent(id);
    }


    public List<Student> getAllStudentBy() {
        return studentRepository.findAllStudent();
    }

    public void updateStudent(Student student, String id) {

       studentRepository.updateStudent(student,id);
    }
}
