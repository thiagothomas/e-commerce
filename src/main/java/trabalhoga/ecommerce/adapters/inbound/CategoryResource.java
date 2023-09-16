package trabalhoga.ecommerce.adapters.inbound;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import trabalhoga.ecommerce.adapters.dto.CategoryDto;
import trabalhoga.ecommerce.application.domain.Category;
import trabalhoga.ecommerce.application.ports.CategoryServicePort;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryResource
{

    @Autowired
    private CategoryServicePort categoryServicePort;

    @GetMapping("/{id}")
    public ResponseEntity<Category> get (@PathVariable UUID id)
    {
        Optional<Category> category = categoryServicePort.findById(id);

        return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Category>> get() {
        return ResponseEntity.ok(categoryServicePort.findAll());
    }

    @PostMapping
    public ResponseEntity<Category> create (@RequestBody @Valid CategoryDto categoryDto)
    {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto, category);
        category = categoryServicePort.save(category);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(category.getId())
                        .toUri();

        return ResponseEntity.created(uri).body(category);
    }

}
