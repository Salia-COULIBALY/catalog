package ml.e_jago.catalog.repositories;

import ml.e_jago.catalog.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

