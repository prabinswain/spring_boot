package com.jdbc.controller;


import com.jdbc.model.Student;
import com.jdbc.service.StudentService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {

        boolean result = studentService.createStudent(student);
        System.out.println("call in controller");
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(null);

    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent() {

        List<Student> students = studentService.getAllStudentBy();
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(students);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable String id) {

        Student student1 = studentService.getStudentById(id);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(student1);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable String id) {

        studentService.updateStudent(student, id);
        return ResponseEntity.status(HttpStatusCode.valueOf(204)).body(null);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeStudent(@PathVariable String id) {

        studentService.removeStudent(id);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body("One student is removed.");

    }


}
