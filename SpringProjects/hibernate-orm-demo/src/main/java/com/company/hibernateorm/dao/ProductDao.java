package com.company.hibernateorm.dao;

import com.company.hibernateorm.entity.Product;
import com.company.hibernateorm.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ProductDao {

    public List<Product> getAllProducts() {

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            String hql = "from Product";

            return session.createQuery(hql, Product.class).list();
        }
    }

    public List<Product> getByPrice(double price) {

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            String hql =
                    "from Product p where p.price = :price";

            return session.createQuery(hql, Product.class)
                    .setParameter("price", price)
                    .list();
        }
    }

    public List<Product> searchByKeyword(String keyword) {

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery(
                            "from Product p where p.name like :key",
                            Product.class
                    )
                    .setParameter("key", "%" + keyword + "%")
                    .list();
        }
    }
}
