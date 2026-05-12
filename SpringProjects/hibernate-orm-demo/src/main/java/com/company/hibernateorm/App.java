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

            Transaction tx = session.beginTransaction();

            Category category1 =
                    new Category("Electronics");

            Category category2 =
                    new Category("Stationary");

            Category category3 =
                    new Category("PoojaItems");

            session.persist(category1);
            session.persist(category2);
            session.persist(category3);

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

            ProductDao dao = new ProductDao();

            System.out.println("\n===== ALL PRODUCTS =====");

            dao.getAllProducts()
                    .forEach(System.out::println);

            System.out.println("\n===== PRICE FILTER =====");

            dao.getByPrice(50000)
                    .forEach(System.out::println);

            System.out.println("\n===== SEARCH FILTER =====");

            dao.searchByKeyword("Lap")
                    .forEach(System.out::println);

            tx.commit();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            HibernateUtil.close();
        }
    }
}
