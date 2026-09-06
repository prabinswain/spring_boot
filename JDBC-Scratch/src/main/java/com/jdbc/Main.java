package com.jdbc;

import com.jdbc.model.Student;
import com.jdbc.repository.StudentRepository;
import com.jdbc.repository.StudentRepositoryBasics;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("IN JDBC app.");

        // too much boiler code.
        StudentRepositoryBasics studentRepositoryBasics = new StudentRepositoryBasics();
//        studentRepositoryBasics.createStudent();
//        studentRepositoryBasics.updateStudent();
//        studentRepositoryBasics.deleteStudent();
//        studentRepositoryBasics.fetchRecord();
//        studentRepositoryBasics.fetchAllRecord();

        StudentRepository studentRepository = new StudentRepository();

//        studentRepository.createStudent(new Student("Rohan", 21,"rohan@gmail.com"));
        studentRepository.updateStudent(new Student("Rakesh", 21,"Rakesh@gmail.com"), 4);

    }
}