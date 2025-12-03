package ml.e_jago.catalog.services;

import ml.e_jago.catalog.entities.Product;
import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    Product getProduct(Long id);
    List<Product> getAllProducts();
}

