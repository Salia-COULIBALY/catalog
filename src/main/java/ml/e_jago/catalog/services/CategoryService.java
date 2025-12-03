package ml.e_jago.catalog.services;

import ml.e_jago.catalog.entities.Category;

import java.util.List;

public interface CategoryService {
    Category saveCategory(Category category);
    Category updateCategory(Long id, Category category);
    void deleteCategory(Long id);
    Category getCategory(Long id);
    List<Category> getAllCategories();
}

