package trabalhoga.ecommerce.adapters.outbound.persistence;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import trabalhoga.ecommerce.adapters.outbound.persistence.entities.CategoryEntity;
import trabalhoga.ecommerce.adapters.outbound.persistence.entities.ProductEntity;
import trabalhoga.ecommerce.adapters.outbound.persistence.repositories.SpringDataPostgresProductRepository;
import trabalhoga.ecommerce.application.domain.Category;
import trabalhoga.ecommerce.application.domain.Product;
import trabalhoga.ecommerce.application.ports.ProductRepositoryPort;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@Primary
public class PostgresProductDb implements ProductRepositoryPort
{
    private final SpringDataPostgresProductRepository repository;

    public PostgresProductDb (final SpringDataPostgresProductRepository repository)
    {
        this.repository = repository;
    }

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Product> findAll ()
    {
        return repository.findAll().stream().map(entity -> modelMapper.map(entity, Product.class))
                        .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findById (UUID productId)
    {
        Optional<ProductEntity> productEntity = repository.findById(productId);
        return productEntity.map(entity -> modelMapper.map(entity, Product.class));
    }

    @Override
    public Product save (Product product)
    {
        ProductEntity productEntity = repository.save(modelMapper.map(product, ProductEntity.class));

        return modelMapper.map(productEntity, Product.class);
    }

    @Override
    public List<Product> findAllByCategory (Category category)
    {
        return repository.findAllByCategories(modelMapper.map(category, CategoryEntity.class))
                        .stream()
                        .map(entity -> modelMapper.map(entity, Product.class))
                        .collect(Collectors.toList());
    }
}
