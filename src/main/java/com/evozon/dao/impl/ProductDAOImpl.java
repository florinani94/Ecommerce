package com.evozon.dao.impl;

import com.evozon.dao.ProductDAO;
import com.evozon.domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;


@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Product> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        List<Product> products = session.createQuery("FROM product as P").list();
        return products;
    }

    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.save(product);
    }

    public void addDefaultProducts() {
        Product product1 = new Product("KX123456", "Adidas", "The best product in town", 20.25, 10);
        Product product2 = new Product("KX173456", "Nike", "The best product in country", 30.25, 10);
        Product product3 = new Product("TX123456", "Milka", "The best product in town", 20.25, 10);

        List<Product> products = getAllProducts();
        if (CollectionUtils.isEmpty(products)) {
            addProduct(product1);
            addProduct(product2);
            addProduct(product3);
        }
    }

}
