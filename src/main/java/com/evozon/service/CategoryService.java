package com.evozon.service;

import com.evozon.dao.CategoryDAO;
import com.evozon.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mihai on 7/12/2016.
 */

@Service
public class CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    public void addCategory(Category category){
        categoryDAO.addCategory(category);
    }

    public void deleteCategory(int categoryId) {
        this.categoryDAO.deleteCategory(categoryId);
    }

    public List<Category> getAllCategories(){
        return categoryDAO.getAllCategories();
    }

    public Category getCategoryById(String id) { return categoryDAO.getCategoryById(id);}
}
