package com.example;

import jakarta.persistence.*;
import jakarta.persistence.Entity;


@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private int stock;
    private String category;
    private String description;

    public Product() {

    }

    public Product(String name, double price, int stock, String category, String description) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
