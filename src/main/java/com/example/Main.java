package com.example;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        ProductDAO productDAO = new ProductDAO();


        Product product = new Product("Maquina", 12, 3,"Electronica","Cuidado Masc");

       product =  productDAO.addProduct(product);

       product = productDAO.getProductById(product.getId());

       System.out.println(product);

       List<Product> productList =  productDAO.getAllProducts();

        for (Product p : productList){
            System.out.println(p);
        }

        product.setName("Vestido");

        productDAO.updateProduct(product);
        System.out.println( productDAO.getProductById(product.getId()));


        productDAO.deleteProduct(product.getId());
        System.out.println( productDAO.getProductById(product.getId()));

    }



}
