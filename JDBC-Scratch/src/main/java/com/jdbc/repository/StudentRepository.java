package com.jdbc.repository;

import com.jdbc.model.Student;

import java.sql.*;


// As Statement it has too much boilerplate and we cannot prepare statement at dynamic so we needs to use Prepared statement.
public class StudentRepository {

    String url = "jdbc:mysql://localhost:3306/student_db";
    String username = "root";
    String password = "Pkswain@123";

    public void createStudent(Student student) {
        String sql = """
                        INSERT INTO student ( name , email , age ) values (?,?,?);
                    """;
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement =
                     connection.prepareStatement(sql);) {

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getAge());

            int i = preparedStatement.executeUpdate();

            if (i == 1){
                System.out.println("Row inserted ");
            }else {
                System.out.println("Insertion failed.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student, Integer id) {
        String sql = """
                        UPDATE student SET name = ? ,
                                            email = ?,
                                            age = ? 
                                            where id = ?
                    """;
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement =
                     connection.prepareStatement(sql);) {

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setInt(4, id);

            int rowAffected =  preparedStatement.executeUpdate();

            if(rowAffected == 1) {
                System.out.println("Update operation successful");
            }
            else {
                System.out.println("Updation failed");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
