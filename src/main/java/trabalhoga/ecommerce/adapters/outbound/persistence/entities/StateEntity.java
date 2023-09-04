package trabalhoga.ecommerce.adapters.outbound.persistence.entities;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class StateEntity {

    private UUID id;
    private String name;

}
