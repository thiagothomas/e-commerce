package trabalhoga.ecommerce.adapters.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryDto
{

    @NotBlank
    private String name;

}
