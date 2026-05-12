package com.company.hibernateorm.dao;

import com.company.hibernateorm.entity.Product;
import com.company.hibernateorm.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ProductDao {

    /* Native SQL Based Query */

    // Scalar Query

    public List<Object[]> findAll() {

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            String sql = "select * from products";

            return session.createNativeQuery(sql).list();
        }
    }

    // Entity Based Query

    public List<Product> getAll() {

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            String sql = "select * from products";

            return session
                    .createNativeQuery(sql, Product.class)
                    .list();
        }
    }

    // Parameterized Query

    public List<Product> getById(int id) {

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            String sql =
                    "select * from products where id = :id";

            return session
                    .createNativeQuery(sql, Product.class)
                    .setParameter("id", id)
                    .list();
        }
    }
}
