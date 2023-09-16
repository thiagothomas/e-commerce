package trabalhoga.ecommerce.adapters.outbound.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trabalhoga.ecommerce.adapters.outbound.persistence.entities.CategoryEntity;
import trabalhoga.ecommerce.adapters.outbound.persistence.entities.ProductEntity;
import trabalhoga.ecommerce.application.domain.Category;
import java.util.List;
import java.util.UUID;

@Repository
public interface SpringDataPostgresProductRepository extends JpaRepository<ProductEntity, UUID> {

    List<ProductEntity> findAllByCategories(CategoryEntity category);

}
