package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name="reportcard")
public class ReportCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double marks;

    public ReportCard() {
    }

    public ReportCard(double marks) {
        this.marks = marks;
    }

    public Long getId() {
        return id;
    }

    public double getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "ReportCard{id=" + id +
                ", marks=" + marks + "}";
    }
}
