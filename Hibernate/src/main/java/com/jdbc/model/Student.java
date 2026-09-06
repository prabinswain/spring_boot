package com.jdbc.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age" )
    private Integer age;

    @Column(name = "email" ,unique = true,  nullable = false)
    private String email;

    @Embedded
    @AttributeOverrides(
            {
                    @AttributeOverride( name = "houseNo",column = @Column(name = "current_house_no")),
                    @AttributeOverride( name = "street",column = @Column(name = "current_street")),
                    @AttributeOverride( name = "city",column = @Column(name = "current_city")),
                    @AttributeOverride( name = "state",column = @Column(name = "current_state")),
                    @AttributeOverride( name = "pin",column = @Column(name = "current_pin"))
            }
    )
    private Address permanentAddress;
    @Embedded
    @AttributeOverrides(
            {
                    @AttributeOverride( name = "houseNo",column = @Column(name = "permanent_house_no")),
                    @AttributeOverride( name = "street",column = @Column(name = "permanent_street")),
                    @AttributeOverride( name = "city",column = @Column(name = "permanent_city")),
                    @AttributeOverride( name = "state",column = @Column(name = "permanent_state")),
                    @AttributeOverride( name = "pin",column = @Column(name = "permanent_pin"))
            }
    )
    private Address currentAddress;

    @ElementCollection
    @CollectionTable(name = "student_skills" , joinColumns = @JoinColumn(name = "student_id"))
    private Set<String> skills;

    @Enumerated(EnumType.STRING)
    private StudentStatus studentStatus;

    @Transient
    private String displayName;

    @Lob
    @Column(name = "student_feedback" )
    private String studentFeedback;

    @Convert(converter = StudentBooleanConverter.class)
    private Boolean isMonitor;

    @Column(name = "created_date")
    private LocalDateTime createdAt;

    @ManyToOne( optional = false , fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id",nullable = false)
    private Department department;

    @OneToOne(cascade = CascadeType.PERSIST , fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "profile_id" , nullable = false , unique = true)
    private StudentProfile profile;

    @ManyToMany
    @JoinTable( name = "student_course"   // Describes the middle table name
            , joinColumns = @JoinColumn(name = "student_id") // forign key pointing to owning entity
            , inverseJoinColumns = @JoinColumn(name = "course_id") // forign key pointing to other entity
            , uniqueConstraints = @UniqueConstraint(columnNames = {"student_id","course_id"})
    )
    private Set<Courses> courses = new HashSet<>();


}
