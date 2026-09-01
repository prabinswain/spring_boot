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

    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    public Student getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    public void removeStudent(Integer id) {
       Student student =  studentRepository.findById(id);
        studentRepository.deleteStudent(student);
    }


    public List<Student> getAllStudentBy() {
        return studentRepository.findAllStudent();
    }

    public void updateStudent(Student student, String id) {

       studentRepository.updateStudent(student,id);
    }
}
