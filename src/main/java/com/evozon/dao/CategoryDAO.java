package com.evozon.dao;

import com.evozon.domain.Category;

import java.util.List;

public interface CategoryDAO {

    void addCategory(Category category);

    void deleteCategory(int categoryId);

    List<Category> getAllCategories();

    Category getCategoryById(String id);
}
