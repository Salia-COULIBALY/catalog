package ml.e_jago.catalog.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import ml.e_jago.catalog.entities.Product;
import ml.e_jago.catalog.services.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Products", description = "Gestion des produits du catalogue")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Créer un produit",
            description = "Ajoute un nouveau produit dans le catalogue.")
    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @Operation(summary = "Mettre à jour un produit",
            description = "Met à jour les informations d'un produit existant.")
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product produit) {
        return productService.updateProduct(id, produit);
    }

    @Operation(summary = "Récupérer un produit",
            description = "Récupère les détails d'un produit spécifique par son ID.")
    @GetMapping("/{id}")
    public Product get(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @Operation(summary = "Lister les produits",
            description = "Récupère la liste de tous les produits du catalogue.")
    @GetMapping
    public List<Product> list() {
        return productService.getAllProducts();
    }

    @Operation(summary = "Supprimer un produit",
            description = "Supprime un produit du catalogue par son ID.")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
