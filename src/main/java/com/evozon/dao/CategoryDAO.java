package com.evozon.dao;

import com.evozon.domain.Category;

public interface CategoryDAO {

    void addCategory(Category category);

    void deleteCategory(int categoryId);

}
