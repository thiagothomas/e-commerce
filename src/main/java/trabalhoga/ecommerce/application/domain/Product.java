package trabalhoga.ecommerce.application.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class Product {

    private UUID id;
    private String name;
    private Double price;
    private Set<Category> categories;

}
