package trabalhoga.ecommerce.adapters.outbound.persistence.entities;

import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class ProductEntity {

    private UUID id;
    private String name;
    private Double price;
    private Set<CategoryEntity> categories;

}
