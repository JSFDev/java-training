package com.platzi.appRestCoursesInstructors.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class InstructorEntity {

    @OneToMany(mappedBy = "instructor")
    private Set<CourseEntity> courses = new HashSet<>();

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    private String password;
    private String username;

    public Set<CourseEntity> getCourses() {
        return this.courses;
    }

    public Long getId() {
        return this.id;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public InstructorEntity(String name, String password) {
        this.username = name;
        this.password = password;
    }

    InstructorEntity() { // jpa only
    }
}
