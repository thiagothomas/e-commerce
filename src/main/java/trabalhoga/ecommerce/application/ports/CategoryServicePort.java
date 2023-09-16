package trabalhoga.ecommerce.application.ports;

import trabalhoga.ecommerce.application.domain.Category;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryServicePort
{

    List<Category> findAll();
    Optional<Category> findById(UUID categoryId);
    Category save(Category category);

}
