package trabalhoga.ecommerce.application.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class Customer {

    private UUID id;
    private String name;
    private String email;
    private String password;

}
