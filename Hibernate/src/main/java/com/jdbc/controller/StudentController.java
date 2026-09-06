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
    public ResponseEntity<String> addStudent(@RequestBody Student student , @RequestParam String departmentName) {

        studentService.createStudent(student,departmentName);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body("Student record inserted.");

    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent() {

        List<Student> students = studentService.getAllStudentBy();
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(students);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Integer id) {

        Student student1 = studentService.getStudentById(id);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(student1);

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@RequestBody Student student, @PathVariable String id) {

        studentService.updateStudent(student, id);
        return ResponseEntity.status(HttpStatusCode.valueOf(204)).body("Update successful.");

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeStudent(@PathVariable Integer id) {

        studentService.removeStudent(id);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body("One student is removed.");

    }

//    @GetMapping("/paging")
//    public  ResponseEntity<List<Student>> getAllResultOnPagingBasics(){
//
//        List<Student> studentList =  studentService.getAllStudentByPaging();
//
//        for (Student student:studentList){
//
//        }
//        return null;
//    }


}
