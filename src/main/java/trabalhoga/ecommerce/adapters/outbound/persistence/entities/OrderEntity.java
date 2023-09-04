package trabalhoga.ecommerce.adapters.outbound.persistence.entities;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class OrderEntity {

    private UUID id;
    private CustomerEntity customerEntity;
    private List<ProductEntity> productEntities;

}
