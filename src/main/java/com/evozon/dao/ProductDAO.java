package com.evozon.dao;

import com.evozon.domain.Product;

import java.util.List;

public interface ProductDAO {

    List<Product> getAllProducts();

    void addDefaultProducts();

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(int productId);

    void importFromFile(String filename);

    Product getProductById(Integer id);

    List<Product> getProductsForPage(int startPageIndex, int recordsPerPage);
}
