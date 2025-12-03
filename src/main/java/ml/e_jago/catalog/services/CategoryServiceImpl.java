package ml.e_jago.catalog.services;

import ml.e_jago.catalog.entities.Category;
import ml.e_jago.catalog.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Category exist = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category non trouvé"));

        exist.setName(category.getName());
        exist.setProducts(category.getProducts());

        return categoryRepository.save(exist);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category non trouvé"));
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}

