package trabalhoga.ecommerce.adapters.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import trabalhoga.ecommerce.application.domain.Category;
import java.util.Set;

@Data
public class ProductDto
{

    @NotEmpty
    private String name;
    @NotNull
    private Double price;
    @NotEmpty
    private Set<Category> categories;

}
