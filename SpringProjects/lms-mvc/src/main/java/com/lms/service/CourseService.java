package com.lms.service;

import com.lms.config.HibernateUtil;
import com.lms.entity.Course;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    public List<Course> getAllCourses() {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        List<Course> courses = session.createQuery(
                "from Course",
                Course.class).list();

        session.close();

        return courses;
    }
}