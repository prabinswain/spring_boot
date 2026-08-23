package com.crud.demo.controller;

import com.crud.demo.dto.request.CreateStudentRequestDTO;
import com.crud.demo.dto.request.UpdateStudentRequestDto;
import com.crud.demo.dto.response.CreateStudentResponseDTO;
import com.crud.demo.dto.response.UpdateStudentResponseDto;
import com.crud.demo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/filter")
    public String hellowWorld(){
        return studentService.getHellowMessage();
    }

    @PostMapping
    public ResponseEntity<CreateStudentResponseDTO> addStudent(@RequestBody @Valid CreateStudentRequestDTO studentRequestDTO){
        CreateStudentResponseDTO result = studentService.createStudent(studentRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateStudentResponseDTO> addStudent(@PathVariable (value = "id") Long id){
        CreateStudentResponseDTO result = studentService.getStudentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping
    public ResponseEntity<List<CreateStudentResponseDTO>> getAllStudents(){
        List<CreateStudentResponseDTO> result = studentService.fetchAllStudents();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping
    public ResponseEntity<UpdateStudentResponseDto> updateStudent(@RequestParam Long id ,@Valid @RequestBody UpdateStudentRequestDto updateStudentRequestDto){
        UpdateStudentResponseDto result = studentService.updateStudent(id , updateStudentRequestDto) ;
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){
       boolean isDeleted = studentService.deleteStudentById(id);
        if (!isDeleted){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Student deleted");
    }


    @PatchMapping("/soft-delete")
    public ResponseEntity<String> softdeleteStudent(@RequestParam Long id){
        boolean isDeleted = studentService.deleteStudentSoftly(id);
        if (!isDeleted){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Student softly deleted");
    }
}
