package com.crud.demo.service;

import com.crud.demo.dto.request.CreateStudentRequestDTO;
import com.crud.demo.dto.request.UpdateStudentRequestDto;
import com.crud.demo.dto.response.CreateStudentResponseDTO;
import com.crud.demo.dto.response.UpdateStudentResponseDto;
import com.crud.demo.entity.Student;
import com.crud.demo.exception.DuplicateEmailEntryException;
import com.crud.demo.exception.StudentNotFoundException;
import com.crud.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // for filters testing
    public String getHellowMessage() {
        return "Hello filters";
    }

    public CreateStudentResponseDTO createStudent(CreateStudentRequestDTO studentRequestDTO) {

        Student student = mapToStudent(studentRequestDTO);
        if (existsByEmail(student.getEmail())){
            throw new DuplicateEmailEntryException("Email is already used.");
        }
        student.setDeleted(false);
        Student studentResp = studentRepository.save(student);
        return mapToStudentResponse(studentResp);
    }

    public CreateStudentResponseDTO getStudentById(Long id) {
        Student student = studentRepository.findByIdAndDeletedIsFalse(id).orElseThrow(() -> new StudentNotFoundException("Student is not present"));
        return mapToStudentResponse(student);
    }

    public List<CreateStudentResponseDTO> fetchAllStudents() {
        List<Student> allByDeletedIsFalse = studentRepository.findAllByDeletedIsFalse();
        List<CreateStudentResponseDTO> createStudentResponseDTOS = new ArrayList<>();

        for (Student student : allByDeletedIsFalse) {
            createStudentResponseDTOS.add(mapToStudentResponse(student));
        }
        return createStudentResponseDTOS;
    }

    public UpdateStudentResponseDto updateStudent(Long id, UpdateStudentRequestDto updateStudentRequestDto) {

        Student existingStudent = studentRepository.findByIdAndDeletedIsFalse(id).orElseThrow(() -> new StudentNotFoundException("Student is not present "));
        System.out.println("call here after findById");

        existingStudent.setFirstName(updateStudentRequestDto.getFirstName());
        existingStudent.setLastName(updateStudentRequestDto.getLastName());
        existingStudent.setAge(updateStudentRequestDto.getAge());
        existingStudent.setPhoneNumber(updateStudentRequestDto.getPhoneNumber());
        existingStudent.setGender(updateStudentRequestDto.getGender());
        existingStudent.setDateOfBirth(updateStudentRequestDto.getDateOfBirth());
        existingStudent.setAddress(updateStudentRequestDto.getAddress());

        Student savedStudent = studentRepository.save(existingStudent);

        return mapToUpdateStudentResponse(savedStudent);

    }

    public boolean deleteStudentById(Long id) {

        boolean result = studentRepository.existsById(id);
        System.out.println(result);
        if (!result) return false;
        studentRepository.deleteById(id);
        return true;
    }

    public boolean deleteStudentSoftly(Long id) {
        Student fetchedStudent = studentRepository.findByIdAndDeletedIsFalse(id).orElseThrow(() -> new StudentNotFoundException("Student is not present "));
        fetchedStudent.setDeleted(true);
        studentRepository.save(fetchedStudent);
        return true;
    }


    // helper method
    private CreateStudentResponseDTO mapToStudentResponse(Student studentResp) {

        CreateStudentResponseDTO response = new CreateStudentResponseDTO();

        response.setId(studentResp.getId());
        response.setRollNumber(studentResp.getRollNumber());
        response.setFirstName(studentResp.getFirstName());
        response.setLastName(studentResp.getLastName());
        response.setAge(studentResp.getAge());
        response.setEmail(studentResp.getEmail());
        response.setPhoneNumber(studentResp.getPhoneNumber());
        response.setGender(studentResp.getGender());
        response.setDateOfBirth(studentResp.getDateOfBirth());
        response.setAddress(studentResp.getAddress());


//        Instant createdAt = studentResp.getCreatedAt();
//        ZonedDateTime indiaTime =
//                createdAt.atZone(ZoneId.of("Asia/Kolkata"));
//        Instant updatedAt = studentResp.getUpdatedAt();
//        ZonedDateTime indiaTime2 =
//                createdAt.atZone(ZoneId.of("Asia/Kolkata"));
//        response.setUpdatedAt(indiaTime2.toInstant());
//        response.setCreatedAt(indiaTime.toInstant());

        response.setUpdatedAt(studentResp.getUpdatedAt());
        response.setCreatedAt(studentResp.getCreatedAt());

        return response;


    }

    private Student mapToStudent(CreateStudentRequestDTO studentRequestDTO) {

        Student student = new Student();

        student.setRollNumber(studentRequestDTO.getRollNumber());
        student.setFirstName(studentRequestDTO.getFirstName());
        student.setLastName(studentRequestDTO.getLastName());
        student.setAge(studentRequestDTO.getAge());
        student.setEmail(studentRequestDTO.getEmail());
        student.setPhoneNumber(studentRequestDTO.getPhoneNumber());
        student.setGender(studentRequestDTO.getGender());
        student.setDateOfBirth(studentRequestDTO.getDateOfBirth());
        student.setAddress(studentRequestDTO.getAddress());
        student.setDeleted(false);

        return student;
    }

    private UpdateStudentResponseDto mapToUpdateStudentResponse(Student studentResp) {

        UpdateStudentResponseDto response = new UpdateStudentResponseDto();

        response.setUpdatedAt(studentResp.getUpdatedAt());
        response.setMessage("Student details updates");
        response.setId(studentResp.getId());
        response.setRollNumber(studentResp.getRollNumber());
        response.setFirstName(studentResp.getFirstName());
        response.setLastName(studentResp.getLastName());
        response.setAge(studentResp.getAge());
        response.setEmail(studentResp.getEmail());
        response.setPhoneNumber(studentResp.getPhoneNumber());
        response.setGender(studentResp.getGender());
        response.setDateOfBirth(studentResp.getDateOfBirth());
        response.setAddress(studentResp.getAddress());

        return response;
    }

    // in prod applications we cant do this, as indexing is not present and it will be gets slowed.
    // needs to keep in cache and indexing.
    private boolean existsByEmail(String email) {
        return studentRepository.existsByEmail(email);
    }


}
