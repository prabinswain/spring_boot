package com.jdbc.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    public Student(){}

    public Student(Integer id, String firstName, String lastName, Integer age, String email, Address permanentAddress,
                   Address currentAddress, Set<String> skills, StudentStatus studentStatus, String displayName,
                   String studentFeedback, Boolean isMonitor, LocalDateTime createdAt) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.permanentAddress = permanentAddress;
        this.currentAddress = currentAddress;
        this.skills = skills;
        this.studentStatus = studentStatus;
        this.displayName = displayName;
        this.studentFeedback = studentFeedback;
        this.isMonitor = isMonitor;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(Address permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public Address getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(Address currentAddress) {
        this.currentAddress = currentAddress;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    public StudentStatus getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(StudentStatus studentStatus) {
        this.studentStatus = studentStatus;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getStudentFeedback() {
        return studentFeedback;
    }

    public void setStudentFeedback(String studentFeedback) {
        this.studentFeedback = studentFeedback;
    }

    public Boolean getMonitor() {
        return isMonitor;
    }

    public void setMonitor(Boolean monitor) {
        isMonitor = monitor;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", permanentAddress=" + permanentAddress +
                ", currentAddress=" + currentAddress +
                ", skills=" + skills +
                ", studentStatus=" + studentStatus +
                ", displayName='" + displayName + '\'' +
                ", studentFeedback='" + studentFeedback + '\'' +
                ", isMonitor=" + isMonitor +
                ", createdAt=" + createdAt +
                '}';
    }
}
