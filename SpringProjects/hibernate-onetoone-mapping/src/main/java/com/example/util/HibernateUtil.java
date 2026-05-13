package com.example.util;

import com.example.model.ReportCard;
import com.example.model.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory =
            buildSessionFactory();

    private static SessionFactory buildSessionFactory() {

        try {

            return new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(ReportCard.class)
                    .buildSessionFactory();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Session Factory Error : " + e
            );
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
