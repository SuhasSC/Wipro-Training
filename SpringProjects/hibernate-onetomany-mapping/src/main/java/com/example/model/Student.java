package com.example.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="reportcard_id")
    private ReportCard reportcard;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="student_id")
    private List<Course> courses =
            new ArrayList<>();

    public Student() {
        super();
    }

    public Student(String name) {
        super();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ReportCard getReportcard() {
        return reportcard;
    }

    public void setReportcard(ReportCard reportcard) {
        this.reportcard = reportcard;
    }

    public void addCourse(Course c) {
        this.courses.add(c);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student [id=" + id +
                ", name=" + name +
                ", reportcard=" + reportcard + "]";
    }
}
