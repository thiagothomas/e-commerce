package trabalhoga.ecommerce.application.services;

import trabalhoga.ecommerce.application.domain.Category;
import trabalhoga.ecommerce.application.ports.CategoryRepositoryPort;
import trabalhoga.ecommerce.application.ports.CategoryServicePort;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CategoryServiceImpl implements CategoryServicePort
{

    private final CategoryRepositoryPort categoryRepositoryPort;

    public CategoryServiceImpl(CategoryRepositoryPort categoryRepositoryPort) {
        this.categoryRepositoryPort = categoryRepositoryPort;
    }

    @Override
    public List<Category> findAll ()
    {
        return categoryRepositoryPort.findAll();
    }

    @Override
    public Optional<Category> findById (UUID categoryId)
    {
        return categoryRepositoryPort.findById(categoryId);
    }

    @Override
    public Category save (Category category)
    {
        return categoryRepositoryPort.save(category);
    }
}
