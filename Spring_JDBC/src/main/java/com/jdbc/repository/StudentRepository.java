package com.jdbc.repository;

import com.jdbc.model.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/*
 * JDBC template has a wrapper and layer over JDBC , it provides a block of methods into an class and u=we will use that class
 *
 *
 * Steps to connect Db
 * 1. Obtain a connection
 * 2. Create a statement
 * 3. Bind parameters values
 * 4. execute the statement
 * 5. Process the result
 * 6. Handle SQL exception
 * 7. Close JDBC resources
 *
 *
 * Spring separates the functionality
 * JDBC responsibility - JDBCTemplate
 * ====================
 * 1. Obtain the connectino - comes from Datasource inyterface
 * 2. Prepare a statement and execution flow
 * 3. Resource clean up
 * 4. Exception handling like - BadSqlGrammarException , SQLIntegrityConstraintViolationException 
 *
 * Developer responsibility
 * --------------------------
 * 1. SQL query
 * 2. SQL parameter values
 * 3. ROw-to-OBJECT mapping
 * 4. Business interpection of the result
 *
 * How spring boot creates DataSource bean
 * ---------------------------------------
 * 1. Detects the Spring jdbc in classpath (pom.xml)
 * 2. Detects the JDBC driver from (.properties or .yml file in maven)
 * 3. read the .properties/.yml file
 * 4. Detects an available connection technique like hikari and pool size
 * 5. Create an configure the connection
 * 6. register the Datasource as a Bean
 *
 *
 * JDBC privides
 * update() - for the insert , update , delete
 * query() - for fetching list of records
 * queryForObject() - exactly one row
 * */

@Repository
public class StudentRepository {

    private JdbcTemplate jdbcTemplate;

    //private StudentRowMapper studentRowMapper = new StudentRowMapper();

    private RowMapper<Student> rowMapper =
            new BeanPropertyRowMapper<>(Student.class);

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public boolean save(Student student) {

        String sql = """
                INSERT INTO student (name,email,age) 
                values (?,?,?);
                """;
        int rowAffected = jdbcTemplate.update(sql,
                student.getName(),
                student.getEmail(),
                student.getAge());

        if (rowAffected == 1)
        {
            System.out.println("Create Student successful");
            return true;
        }else{
            System.out.println("Create Student failed");
            return false;
        }


    }

    public Student findById(String id) {
        String sql = """
                SELECT id,name,email,age from student
                """;
       return jdbcTemplate.queryForObject(sql,rowMapper,id);
    }

    public boolean deleteStudent(String id) {
        String sql = """
                DELETE from student where id = ?
                """;
        int rowAffected = jdbcTemplate.update(sql, id);
        if (rowAffected == 1)
        {
            System.out.println("Student is deleted ");
            return true;
        }else{
            System.out.println("Delete Student failed");
            return false;
        }

    }

    public List<Student> findAllStudent() {

        String sql = """
                SELECT id,name,email,age from student
                """;

        List<Student> studentList = jdbcTemplate.query(sql, rowMapper);
        return studentList;
    }

    public void updateStudent(Student student, String id) {

        String sql = """
                UPDATE student set 
                    name = ?,
                    email = ?,
                    age = ?
                    where id = ?
                """;

        int rowAffected = jdbcTemplate.update(sql, student.getName(), student.getEmail(), student.getAge(), id);
        if(rowAffected == 1) {
            System.out.println("Update operation successful");
        }
        else {
            System.out.println("Updation failed");
        }
    }
}
