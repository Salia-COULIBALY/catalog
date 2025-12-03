package ml.e_jago.catalog.services;


import ml.e_jago.catalog.entities.Product;
import ml.e_jago.catalog.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product exist = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));

        exist.setName(product.getName());
        exist.setDescription(product.getDescription());
        exist.setPrice(product.getPrice());
        exist.setQuantity(product.getQuantity());
        exist.setStatus(product.getStatus());
        exist.setCategory(product.getCategory());

        return productRepository.save(exist);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}

