package trabalhoga.ecommerce.application.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class Product {

    private UUID id;
    private String name;
    private Double price;
    private Set<Category> categories;

}
