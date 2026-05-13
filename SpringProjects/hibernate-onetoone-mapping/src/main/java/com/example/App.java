package com.example;

import com.example.model.ReportCard;
import com.example.model.Student;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    public static void main(String[] args) {

        Session session =
                HibernateUtil.getSessionFactory().openSession();

        Transaction tx = session.beginTransaction();

        ReportCard rc = new ReportCard(95);

        Student s = new Student("Suhas");

        s.setReportcard(rc);

        session.persist(s);

        tx.commit();

        System.out.println("One-To-One Mapping Done!");

        session.close();
    }
}
