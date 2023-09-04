package trabalhoga.ecommerce.adapters.outbound.persistence.entities;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CityEntity {

    private UUID id;
    private String name;
    private StateEntity stateEntity;

}
