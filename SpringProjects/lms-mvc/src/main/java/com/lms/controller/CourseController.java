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
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/course-form")
    public String courseForm() {
        return "course-form";
    }

    @PostMapping("/save-course")
    public String saveCourse(@RequestParam("title") String title) {

        Course course = new Course();
        course.setTitle(title);

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction tx = session.beginTransaction();

        session.save(course);

        tx.commit();
        session.close();

        return "redirect:/courses";
    }

    @GetMapping("/courses")
    public String viewCourses(Model model) {

        List<Course> courses = courseService.getAllCourses();

        List<Student> students = studentService.getAllStudents();

        model.addAttribute("courses", courses);

        model.addAttribute("students", students);

        return "view";
    }

    @GetMapping("/delete-course/{id}")
    public String deleteCourse(@PathVariable int id) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction tx = session.beginTransaction();

        Course course = session.get(Course.class, id);

        if (course != null) {
            session.delete(course);
        }

        tx.commit();
        session.close();

        return "redirect:/courses";
    }
}