package ml.e_jago.catalog.repositories;

import ml.e_jago.catalog.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

