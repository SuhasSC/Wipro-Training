package com.lms.service;

import com.lms.config.HibernateUtil;
import com.lms.entity.Student;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    public List<Student> getAllStudents() {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        List<Student> students = session.createQuery(
                "from Student",
                Student.class).list();

        session.close();

        return students;
    }
}