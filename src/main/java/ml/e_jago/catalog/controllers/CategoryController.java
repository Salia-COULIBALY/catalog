package ml.e_jago.catalog.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import ml.e_jago.catalog.entities.Category;
import ml.e_jago.catalog.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Categories", description = "Gestion des categories du catalogue")
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Operation(summary = "Créer une catégorie",
            description = "Ajoute une nouvelle catégorie dans le catalogue.")
    @PostMapping
    public Category create(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @Operation(summary = "Mettre à jour une catégorie",
            description = "Met à jour les informations d'une catégorie existante.")
    @PutMapping("/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }

    @Operation(summary = "Récupérer une catégorie",
            description = "Récupère les détails d'une catégorie spécifique par son ID.")
    @GetMapping("/{id}")
    public Category get(@PathVariable Long id) {
        return categoryService.getCategory(id);
    }

    @Operation(summary = "Lister les catégories",
            description = "Récupère la liste de toutes les catégories du catalogue.")
    @GetMapping
    public List<Category> list() {
        return categoryService.getAllCategories();
    }

    @Operation(summary = "Supprimer une catégorie",
            description = "Supprime une catégorie du catalogue par son ID.")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
