package com.evozon.dao;

import com.evozon.domain.Category;

import java.util.List;

public interface CategoryDAO {

    void addCategory(Category category);

    List<Category> getAllCategories();

}
