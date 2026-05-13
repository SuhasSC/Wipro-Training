package com.lms.controller;

import com.lms.config.HibernateUtil;
import com.lms.entity.Course;
import com.lms.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EnrollmentController {

    @GetMapping("/enroll-form")
    public String enrollForm(Model model) {

        Session session =
                HibernateUtil
                .getSessionFactory()
                .openSession();

        List<Student> students =
                session.createQuery(
                        "from Student",
                        Student.class
                ).list();

        List<Course> courses =
                session.createQuery(
                        "from Course",
                        Course.class
                ).list();

        model.addAttribute("students", students);
        model.addAttribute("courses", courses);

        session.close();

        return "enroll-form";
    }

    @PostMapping("/save-enrollment")
    public String saveEnrollment(
            @RequestParam Long studentId,
            @RequestParam List<Long> courseIds
    ) {

        Session session =
                HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction tx =
                session.beginTransaction();

        Student student =
                session.get(Student.class, studentId);

        student.getCourses().clear();

        for(Long id : courseIds){

            Course course =
                    session.get(Course.class, id);

            student.addCourse(course);
        }

        session.update(student);

        tx.commit();

        session.close();

        return "redirect:/enrollments";
    }

    @GetMapping("/enrollments")
    public String enrollments(Model model) {

        Session session =
                HibernateUtil
                .getSessionFactory()
                .openSession();

        List<Student> students =
                session.createQuery(
                        "from Student",
                        Student.class
                ).list();

        List<Course> courses =
                session.createQuery(
                        "from Course",
                        Course.class
                ).list();

        model.addAttribute("students", students);
        model.addAttribute("courses", courses);

        session.close();

        return "enrollment-view";
    }
}
