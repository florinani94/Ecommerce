package com.evozon.dao.impl;

import com.evozon.dao.CategoryDAO;
import com.evozon.domain.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mihai on 7/12/2016.
 */
@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public void addCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.save(category);
    }
}
