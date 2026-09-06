package com.jdbc.repository;

import com.jdbc.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


// too much boiler code.
// We are putting values in queries mannuallly but in application it should be dynamic.
// and the problem is very hign in Statemenr so we need to use PreparedStatement.
public class StudentRepositoryBasics {

    String url = "jdbc:mysql://localhost:3306/student_db";
    String username = "root";
    String password = "Pkswain@123";

    // create a new Student
    public void createStudent() {

        try (Connection connection = DriverManager.getConnection(url, username, password);) {


            String sql = """
                        INSERT INTO student (name, email, age) values ( "alok ", "alok1@gmail.com", 23);
                    """;
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(sql);
            if (result == 1) {
                System.out.println("Student record inserted ");
            } else {
                System.out.println("Something error occured");
            }
            System.out.println("after the call flow back to repository. ");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // update a new Student
    public void updateStudent() {

        try (Connection connection = DriverManager.getConnection(url, username, password);) {


            String sql = """
                        UPDATE student SET name = "deepak", email = "deepak@gmail.com", age = 25 where id=1;
                    """;
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(sql);
            if (result == 1) {
                System.out.println("Student record updated");
            } else {
                System.out.println("Something error occured");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // update a new Student
    public void deleteStudent() {

        try (Connection connection = DriverManager.getConnection(url, username, password);) {

            String sql = """
                        delete from student where id=1;
                    """;
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(sql);

            if (result == 1) {
                System.out.println("Student record deleted");
            } else {
                System.out.println("Something error occured");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void fetchRecord() {

        try (Connection connection = DriverManager.getConnection(url, username, password);) {

            String sql = """
                        select id,name,email,age from student where id=2;
                    """;
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            System.out.println("result came back seccessfulluy ");
            if (result.next()) {
                long id = result.getInt("id");
                String name = result.getString("name");
                String email = result.getString("email");
                long age = result.getInt("age");

                System.out.println(" all the fileds : " + id + "," + name + "," + email + "," + age);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void fetchAllRecord() {

        try (Connection connection = DriverManager.getConnection(url, username, password);) {

            String sql = """
                        select id,name,email,age from student;
                    """;
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            System.out.println("result came back seccessfulluy ");

            List<Student> studentList = new ArrayList<>();

            while (result.next()) {

                Student student = mapToRow(result);
                studentList.add(student);
                System.out.println(student);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private Student mapToRow(ResultSet result) {

        Student student = new Student();
        try {
            student.setId(result.getInt("id"));
            student.setName(result.getString("name"));
            student.setEmail(result.getString("email"));
            student.setAge(result.getInt("age"));
        } catch (SQLException e) {
        }
        return student;
    }
}
