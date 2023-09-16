package trabalhoga.ecommerce.adapters.outbound.persistence;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import trabalhoga.ecommerce.adapters.outbound.persistence.entities.CategoryEntity;
import trabalhoga.ecommerce.adapters.outbound.persistence.repositories.SpringDataPostgresCategoryRepository;
import trabalhoga.ecommerce.application.domain.Category;
import trabalhoga.ecommerce.application.ports.CategoryRepositoryPort;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@Primary
public class PostgresCategoryDb implements CategoryRepositoryPort
{

    private final SpringDataPostgresCategoryRepository repository;

    public PostgresCategoryDb (final SpringDataPostgresCategoryRepository repository)
    {
        this.repository = repository;
    }

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Category> findAll ()
    {
        return repository.findAll().stream().map(entity -> modelMapper.map(entity, Category.class))
                        .collect(Collectors.toList());
    }

    @Override
    public Optional<Category> findById (UUID categoryId)
    {
        Optional<CategoryEntity> categoryEntity = repository.findById(categoryId);
        return categoryEntity.map(entity -> modelMapper.map(entity, Category.class));
    }

    @Override
    public Category save (Category category)
    {
        CategoryEntity categoryEntity = repository.save(modelMapper.map(category, CategoryEntity.class));

        return modelMapper.map(categoryEntity, Category.class);
    }
}
