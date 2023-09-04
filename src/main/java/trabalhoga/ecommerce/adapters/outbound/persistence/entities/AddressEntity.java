package trabalhoga.ecommerce.adapters.outbound.persistence.entities;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class AddressEntity {

    private UUID id;
    private String street;
    private String number;
    private String complement;
    private String cep;
    private CityEntity cityEntity;

}
