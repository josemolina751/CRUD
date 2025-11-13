package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.swing.*;
import java.sql.*;
import java.util.List;

public class ProductDAO {
    public Product addProduct(Product product) throws SQLException {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(product);
            tx.commit();
        }
        return product;
    }

    public Product getProductById(int id) throws SQLException {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Product product = session.get(Product.class, id);
            return product;
        }
    }

    public List<Product> getAllProducts() throws SQLException {
        List<Product> products;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Product> query = session.createQuery("FROM Product", Product.class);
            products = query.list();
        }

        return products;
    }

    public void updateProduct(Product product) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Transaction tx = session.beginTransaction();
            session.merge(product);
            tx.commit();
        }
    }

    public void deleteProduct(int id) throws SQLException {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Transaction tx = session.beginTransaction();
            session.remove(getProductById(id));
            tx.commit();
        }
    }
}
