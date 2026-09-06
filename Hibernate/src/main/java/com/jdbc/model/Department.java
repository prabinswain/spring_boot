package com.jdbc.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    private String departmentName;

//    @OneToMany(mappedBy = "department",cascade = CascadeType.PERSIST)
//    private List<Student> studentList = new ArrayList<>();

}
