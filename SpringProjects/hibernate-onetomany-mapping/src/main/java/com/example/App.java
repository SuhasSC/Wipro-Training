package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Course;
import com.example.model.ReportCard;
import com.example.model.Student;
import com.example.util.HibernateUtil;

public class App {

    public static void main(String[] args) {

        Session session =
                HibernateUtil.getSessionFactory().openSession();

        Transaction tx =
                session.beginTransaction();

        Student s1 = new Student("Niti");
        s1.addCourse(new Course("Java"));
        s1.addCourse(new Course("PD"));

        ReportCard rc1 = new ReportCard(450);
        s1.setReportcard(rc1);

        Student s2 = new Student("Rahul");
        s2.addCourse(new Course("Spring"));
        s2.addCourse(new Course("Hibernate"));

        ReportCard rc2 = new ReportCard(500);
        s2.setReportcard(rc2);

        Student s3 = new Student("Amit");
        s3.addCourse(new Course("React"));
        s3.addCourse(new Course("JS"));

        ReportCard rc3 = new ReportCard(420);
        s3.setReportcard(rc3);

        session.persist(s1);
        session.persist(s2);
        session.persist(s3);

        tx.commit();

        session.close();

        Session getSession =
                HibernateUtil.getSessionFactory().openSession();

        Student stud =
                getSession.get(Student.class, 1L);

        System.out.println(
                "Student Details : " + stud.getName()
        );

        stud.getCourses().forEach(
                c -> System.out.println(
                        "Courses enrolled for : "
                                + c.getTitle()
                )
        );

        getSession.close();
    }
}
