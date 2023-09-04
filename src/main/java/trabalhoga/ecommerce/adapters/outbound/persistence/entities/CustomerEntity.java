package trabalhoga.ecommerce.adapters.outbound.persistence.entities;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CustomerEntity {

    private UUID id;
    private String name;
    private String email;
    private String password;
    private AddressEntity address;

}
