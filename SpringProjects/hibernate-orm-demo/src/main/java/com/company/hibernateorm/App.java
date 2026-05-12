package com.company.hibernateorm;

import com.company.hibernateorm.dao.ProductDao;
import com.company.hibernateorm.entity.Category;
import com.company.hibernateorm.entity.Product;
import com.company.hibernateorm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    public static void main(String[] args) {

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            Transaction tx =
                    session.beginTransaction();

            Category category1 =
                    new Category("Electronics");

            Category category2 =
                    new Category("Stationary");

            session.persist(category1);
            session.persist(category2);

            session.persist(
                    new Product("Laptop", 50000, category1)
            );

            session.persist(
                    new Product("Tablet", 40000, category1)
            );

            session.persist(
                    new Product("Mouse", 1000, category1)
            );

            session.persist(
                    new Product("Book", 150, category2)
            );

            session.persist(
                    new Product("Pen", 20, category2)
            );

            tx.commit();

            ProductDao dao = new ProductDao();

            System.out.println(
                    "\n===== Native SQL Queries ====="
            );

            System.out.println(
                    "\n1. Scalar Query"
            );

            dao.findAll()
                    .forEach(
                            p -> System.out.println(
                                    p[0] + " " +
                                    p[1] + " " +
                                    p[2]
                            )
                    );

            System.out.println(
                    "\n2. Entity Query"
            );

            dao.getAll()
                    .forEach(System.out::println);

            System.out.println(
                    "\n3. Parameterized Query"
            );

            dao.getById(1)
                    .forEach(System.out::println);

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            HibernateUtil.close();
        }
    }
}
