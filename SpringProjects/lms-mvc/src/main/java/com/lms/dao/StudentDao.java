package com.lms.dao;

import com.lms.config.HibernateUtil;
import com.lms.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDao {

    public void saveStudent(Student student){

        Session session =
                HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction tx =
                session.beginTransaction();

        session.persist(student);

        tx.commit();

        session.close();
    }

    public List<Student> getAllStudents(){

        Session session =
                HibernateUtil
                .getSessionFactory()
                .openSession();

        List<Student> students =
                session.createQuery(
                        "from Student",
                        Student.class
                ).list();

        session.close();

        return students;
    }

    public void deleteStudent(int id){

        Session session =
                HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction tx =
                session.beginTransaction();

        Student student =
                session.get(Student.class,id);

        if(student != null){

            session.remove(student);

        }

        tx.commit();

        session.close();
    }
}
