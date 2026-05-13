package com.lms.dao;

import com.lms.config.HibernateUtil;
import com.lms.entity.Course;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CourseDao {

    public void saveCourse(Course course){

        Session session =
                HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction tx =
                session.beginTransaction();

        session.persist(course);

        tx.commit();

        session.close();
    }

    public List<Course> getAllCourses(){

        Session session =
                HibernateUtil
                .getSessionFactory()
                .openSession();

        List<Course> courses =
                session.createQuery(
                        "from Course",
                        Course.class
                ).list();

        session.close();

        return courses;
    }

    public void deleteCourse(int id){

        Session session =
                HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction tx =
                session.beginTransaction();

        Course course =
                session.get(Course.class,id);

        if(course != null){

            session.remove(course);

        }

        tx.commit();

        session.close();
    }
}
