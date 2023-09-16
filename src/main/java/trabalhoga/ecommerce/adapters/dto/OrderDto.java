package trabalhoga.ecommerce.adapters.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import trabalhoga.ecommerce.application.domain.Customer;
import trabalhoga.ecommerce.application.domain.Payment;
import trabalhoga.ecommerce.application.domain.Product;
import java.util.List;
import java.util.UUID;

@Data
public class OrderDto
{

    @NotNull
    private Customer customer;
    @NotEmpty
    private List<Product> products;

}
