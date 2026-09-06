package com.jdbc.service;

import com.jdbc.model.Courses;
import com.jdbc.model.Department;
import com.jdbc.model.Student;
import com.jdbc.model.StudentProfile;
import com.jdbc.repository.DepartmentRepository;
import com.jdbc.repository.ProfileRepository;
import com.jdbc.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;
    private final ProfileRepository profileRepository;

    public StudentService(StudentRepository studentRepository, DepartmentRepository departmentRepository,
                          ProfileRepository profileRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
        this.profileRepository = profileRepository;
    }

    @Transactional
    public void createStudent(Student student, String departmentName) {

        Department department = new Department();
        department.setDepartmentName(departmentName);

        StudentProfile profile = new StudentProfile();
        profile.setBio("I am a circle");

//        Set<Courses> courseList = Set.of("BCA", Set.of());
        student.setProfile(profile);
        student.setDepartment(department);
        profileRepository.save(profile);
        departmentRepository.save(department);
        studentRepository.save(student);
    }

    @Transactional
    public Student getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    @Transactional
    public void removeStudent(Integer id) {
        Student student = studentRepository.findById(id);
        studentRepository.deleteStudent(student);
    }

    @Transactional
    public List<Student> getAllStudentBy() {
        return studentRepository.findAllStudent();
    }

    @Transactional
    public void updateStudent(Student student, String id) {
        studentRepository.updateStudent(student, id);
    }

    public List<Student> getAllStudentByPaging() {

        return null;
    }
}
