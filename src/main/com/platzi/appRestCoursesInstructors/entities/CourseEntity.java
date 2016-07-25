package com.platzi.appRestCoursesInstructors.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CourseEntity {

    @ManyToOne
    @JsonIgnore
    private InstructorEntity instructor;


    @Id
    @GeneratedValue
    private Long id;

    private String description;


    public InstructorEntity getInstructor() {
        return this.instructor;
    }

    public Long getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public CourseEntity(InstructorEntity instructor, String description) {
        this.description = description;
        this.instructor = instructor;
    }

    CourseEntity() {// jpa only

    }
}
