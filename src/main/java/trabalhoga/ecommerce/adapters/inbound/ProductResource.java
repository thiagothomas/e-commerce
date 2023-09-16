package trabalhoga.ecommerce.adapters.inbound;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import trabalhoga.ecommerce.adapters.dto.ProductDto;
import trabalhoga.ecommerce.application.domain.Category;
import trabalhoga.ecommerce.application.domain.Product;
import trabalhoga.ecommerce.application.ports.ProductServicePort;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductResource
{

    @Autowired
    private ProductServicePort productServicePort;

    @GetMapping("/{id}")
    public ResponseEntity<Product> get (@PathVariable UUID id)
    {
        Optional<Product> product = productServicePort.findById(id);

        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(params = {"categoryId"})
    public ResponseEntity<List<Product>> getByCategoryId (@RequestParam("categoryId") UUID categoryId)
    {
        return ResponseEntity.ok(productServicePort.findAllByCategory(Category.builder().id(categoryId).build()));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productServicePort.findAll());
    }

    @PostMapping
    public ResponseEntity<Product> create (@RequestBody @Valid ProductDto productDto)
    {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        product = productServicePort.save(product);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(product.getId())
                        .toUri();

        return ResponseEntity.created(uri).body(product);
    }

}
