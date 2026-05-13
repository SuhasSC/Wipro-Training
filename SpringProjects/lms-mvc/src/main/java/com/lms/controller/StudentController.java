package com.lms.controller;

import com.lms.config.HibernateUtil;
import com.lms.entity.Course;
import com.lms.entity.Student;
import com.lms.service.CourseService;
import com.lms.service.StudentService;

import org.hibernate.Session;
import org.hibernate.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/student-form")
    public String studentForm() {
        return "student-form";
    }

    @PostMapping("/save-student")
    public String saveStudent(@RequestParam("name") String name) {

        Student student = new Student();
        student.setName(name);

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction tx = session.beginTransaction();

        session.save(student);

        tx.commit();
        session.close();

        return "redirect:/students";
    }

    @GetMapping("/students")
    public String viewStudents(Model model) {

        List<Student> students = studentService.getAllStudents();

        List<Course> courses = courseService.getAllCourses();

        model.addAttribute("students", students);

        model.addAttribute("courses", courses);

        return "view";
    }

    @GetMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable int id) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class, id);

        if (student != null) {
            session.delete(student);
        }

        tx.commit();
        session.close();

        return "redirect:/students";
    }
}