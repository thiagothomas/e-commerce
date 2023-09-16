package trabalhoga.ecommerce.application.ports;

import trabalhoga.ecommerce.application.domain.Category;
import trabalhoga.ecommerce.application.domain.Product;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductServicePort
{

    List<Product> findAll();
    Optional<Product> findById(UUID productId);
    Product save(Product product);

    List<Product> findAllByCategory(Category category);

}
