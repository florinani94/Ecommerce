package com.evozon.dao.impl;

import com.evozon.dao.ProductDAO;
import com.evozon.domain.Product;
import org.hibernate.Query;
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
        return session.createQuery("FROM Product as P").list();
    }


    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.save(product);
    }

    public void importFromFile(String filename) {
        Session session=sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("LOAD DATA LOCAL INFILE :filename INTO TABLE product FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n' IGNORE 1 LINES (code, description, name, price, stockLevel)").setString("filename", filename);
        int rowCount = query.executeUpdate();
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
