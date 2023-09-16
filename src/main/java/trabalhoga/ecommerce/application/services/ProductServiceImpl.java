package trabalhoga.ecommerce.application.services;

import trabalhoga.ecommerce.application.domain.Category;
import trabalhoga.ecommerce.application.domain.Product;
import trabalhoga.ecommerce.application.ports.ProductRepositoryPort;
import trabalhoga.ecommerce.application.ports.ProductServicePort;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProductServiceImpl implements ProductServicePort
{

    private final ProductRepositoryPort productRepositoryPort;

    public ProductServiceImpl (ProductRepositoryPort productRepositoryPort)
    {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public List<Product> findAll ()
    {
        return productRepositoryPort.findAll();
    }

    @Override
    public Optional<Product> findById (UUID productId)
    {
        return productRepositoryPort.findById(productId);
    }

    @Override
    public Product save (Product product)
    {
        return productRepositoryPort.save(product);
    }

    @Override
    public List<Product> findAllByCategory (Category category)
    {
        return productRepositoryPort.findAllByCategory(category);
    }
}
